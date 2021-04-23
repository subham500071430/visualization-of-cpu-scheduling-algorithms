import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class CompareWT extends Application{

	   
		static List<Integer> a = new ArrayList<Integer>();
		public static void main(String[] args) throws Exception{
			
			
			try {  
				  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
				  Statement st=con.createStatement();
				  ResultSet rs= st.executeQuery("SELECT * FROM comp");
				   
				     while(rs.next()) {
					 a.add(rs.getInt(4));
				    }
				 
				   st.close();
				  }
				  catch(Exception e) {
					  System.out.println("Error occured while fetching the records from DB"+e);
		      }
			launch(args);
		}
			 
		
		public void start(Stage primaryStage) throws Exception{
		  	
		  	ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
		  			new PieChart.Data("FCFS",a.get(0)),
		  			new PieChart.Data("RR",a.get(1)),
		  			new PieChart.Data("SJF",a.get(2))
		  			);
		  	PieChart pchart = new PieChart(pieData);
		  	Group root = new Group(pchart);
		  	Scene scene = new Scene(root,600,400);
		  	primaryStage.setTitle("WTPieChart");
		  	primaryStage.setScene(scene);
		  	primaryStage.show();
		  }
}
