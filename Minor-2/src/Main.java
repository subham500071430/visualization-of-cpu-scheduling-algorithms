import java.io.*;   
import java.sql.*; 
import java.util.*;  

public class Main{
  
	  ArrayList<Integer> id=new ArrayList<Integer>();
	  ArrayList<Integer> at=new ArrayList<Integer>();
	  ArrayList<Integer> bt=new ArrayList<Integer>();
	  float avg1,avg2,avg3,avg4,ravg1,ravg2;
	  
  public static void main (String[] args) throws IOException{
	           Main obj = new Main();
	           obj.getConnection();
	          
  }
  
  public void getConnection() {
	  
	  try {  
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		  Statement st=con.createStatement();
		  ResultSet rs= st.executeQuery("SELECT * FROM time");
		   
		  while(rs.next()) { 
			 id.add(rs.getInt(1));
			 at.add(rs.getInt(2));
			 bt.add(rs.getInt(3));
		  }
		  getFCFS(st);
		  getRR(st);
		  getSJF(st);
		  st.close();
		  }
		  catch(Exception e) {
			  System.out.println("Error occured while fetching the records from DB"+e);
		  }
	  
  }
  public void getFCFS(Statement st) throws Exception{
	  int wt[]=new int[id.size()];
	  int tat[]=new int[id.size()];
	  Fcfs obj=new Fcfs();
	  obj.findWaitingTime(bt,at,wt,id.size());
	  obj.findTurnAroundTime(bt,wt,tat,id.size());
	  avg1=obj.findavgWTime(wt,id.size());                       
	  avg2=obj.findavgTTime(tat,id.size());                     
	  String query = "insert into comp (algorithm,throughput,tat,wt) values ('"+"FCFS"+"','"+"High"+"','"+avg2+"','"+avg1+"')";
	  st.execute(query);
  }
  public void getSJF(Statement st) throws Exception{
	  int swt[]=new int[id.size()];
	  int stat[]=new int[id.size()];
	  Sjf sobj=new Sjf();
	  sobj.findWaitingTime(bt,at,swt,id.size());
	  sobj.findTurnAroundTime(bt,swt,stat,id.size());
	  avg3=sobj.findavgWTime(swt,id.size());
	  avg4=sobj.findavgTTime(stat,id.size());
	  String squery = "insert into comp (algorithm,throughput,tat,wt) values ('"+"SJF"+"','"+"High"+"','"+avg4+"','"+avg3+"')";
	  st.execute(squery);
  }
  public void getRR(Statement st) throws Exception{
	  int rwt[]=new int[id.size()];
	  int rtat[]=new int[id.size()];
	  System.out.print("Enter Time Quantum : ");
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  int tq=Integer.parseInt(br.readLine());                  
	  Roundrobin myobj=new Roundrobin();
	  myobj.findWaitingTime(id,id.size(),bt,rwt,tq);
	  myobj.findTurnAroundTime(id,id.size(),bt,rwt,rtat);
	  ravg1 = myobj.findWTavgTime(rwt,id.size()); 
	  ravg2 = myobj.findTATavgTime(rtat,id.size());
	  String rquery = "insert into comp (algorithm,throughput,tat,wt) values ('"+"RR"+"','"+"High"+"','"+ravg2+"','"+ravg1+"')";
	  st.execute(rquery);
  }
}
