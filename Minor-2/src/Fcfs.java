import java.util.ArrayList;

public class Fcfs { 
	public void findWaitingTime(ArrayList<Integer> bt,ArrayList<Integer> at,int[] wt,int n) 
       { 
        wt[0] = 0; 
        int total_bt=0;
    
        for (int i = 1; i < n; i++) {
        	total_bt+=bt.get(i-1);
        	if(total_bt-at.get(i)<0)
        		wt[i]=0;
        	else
            wt[i] = total_bt-at.get(i); 
        } 
    }  
	public void findTurnAroundTime(ArrayList<Integer> bt, int wt[], int tat[],int n) { 
        for (int i = 0; i < n; i++) { 
            tat[i] = bt.get(i) + wt[i];    
        } 
    } 
	public float findavgWTime(int wt[],int n) { 
		int total_wt=0;
        for (int i = 0; i < n; i++) { 
            total_wt = total_wt + wt[i]; 
        } 
        return (float)total_wt/n;
    } 
	public float findavgTTime(int tat[],int n) { 
		int total_tat=0;
        for (int i = 0; i < n; i++) {  
            total_tat = total_tat + tat[i]; 
        } 
        return (float)total_tat/n;
    } 
}
