import java.util.ArrayList;
public class Priority {

void findWaitingTime(ArrayList<Integer> bt, int n,int[] wt)  				
{  
	wt[0] = 0;  
	for (int i = 1; i < n ; i++ ) 
		wt[i] = bt.get(i-1) + wt[i-1] ; 
} 

void findTurnAroundTime(ArrayList<Integer> bt, int n,int wt[], int tat[])  
						
{ 
	for (int i = 0; i < n ; i++) 
		tat[i] = bt.get(i) + wt[i]; 
} 

float findavgWTime(int[] wt,int n) 
{ 
	int total_wt = 0; 
	for (int i=0; i<n; i++) 
	{ 
		total_wt = total_wt + wt[i]; 
	}
	return (float)total_wt/n; 
} 
float findavgTTime(int[] tat,int n) 
{ 
	int total_tat = 0; 
	for (int i=0; i<n; i++) 
	{ 
		total_tat = total_tat + tat[i];  
	}
	return (float)total_tat/n;  
}  
}
