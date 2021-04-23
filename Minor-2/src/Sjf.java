import java.util.*;
public class Sjf {
	 
		public void findWaitingTime(ArrayList<Integer> bt,ArrayList<Integer> at,int wt[],int n)								 
		{ 
			int rt[] = new int[n]; 
		
			for (int i = 0; i < n; i++)                                              
				rt[i] = bt.get(i); 
		
			int complete = 0, t = 0, minm = Integer.MAX_VALUE; 
			int shortest = 0, finish_time; 
			boolean check = false; 
		
			                                                                          
			while (complete != n) { 
		
				for (int j = 0; j < n; j++)                                          				                                                                
				{ 
					if ((at.get(j) <= t) &&(rt[j] < minm) && rt[j] > 0) { 
						minm = rt[j]; 
						shortest = j; 
						check = true; 
					} 
				} 
		
				if (check == false) { 
					t++; 
					continue; 
				}  
				rt[shortest]--;
				minm = rt[shortest]; 
				if (minm == 0) 
					minm = Integer.MAX_VALUE; 
		
				if (rt[shortest] == 0) { 
					complete++; 
					check = false;  
					finish_time = t + 1; 
					wt[shortest] = finish_time - bt.get(shortest) - at.get(shortest); 				
					if (wt[shortest] < 0) 
						wt[shortest] = 0; 
				} 
				t++; 
			} 
		} 
		public void findTurnAroundTime(ArrayList<Integer> bt, int wt[], int tat[],int n)						 
		{ 
			for (int i = 0; i < n; i++) 
				tat[i] = bt.get(i) + wt[i]; 
		} 
		public float findavgWTime(int[] wt, int n) 
		{ 
			int total_wt = 0; 
			for (int i = 0; i < n; i++) { 
				total_wt = total_wt + wt[i]; 
			} 
			return (float)total_wt/n;
		} 
		public float findavgTTime(int[] tat, int n) 
		{ 
			int total_tat = 0; 
			for (int i = 0; i < n; i++) {  
				total_tat = total_tat + tat[i]; 
			} 
			return (float)total_tat/n;
		} 
		
}
