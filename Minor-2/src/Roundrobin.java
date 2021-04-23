import java.util.ArrayList;
public class Roundrobin {

		public void findWaitingTime(ArrayList<Integer>p, int n,ArrayList<Integer> bt, int wt[], int quantum)			 
		{ 
			                                                                        
			int rem_bt[] = new int[n];                                 
                                                                      
			for (int i = 0 ; i < n ; i++) 
				rem_bt[i] = bt.get(i); 
		
			int t = 0;                                                 
		 
			while(true) 
			{ 
				boolean done = true; 
		
				                                                       
				for (int i = 0 ; i < n; i++) 
				{  
					if (rem_bt[i] > 0) 
					{ 
						done = false;                                  
		
						if (rem_bt[i] > quantum) 
						{ 
							                                        	                                           
							t += quantum; 
							rem_bt[i] -= quantum;                      		                                           
						} 					                                                  		                                            
						else
						{ 
							t = t + rem_bt[i];                         
							                                           
							wt[i] = t - bt.get(i);                     
							                                           		 
		                    rem_bt[i] = 0;                             			                                           
						} 
					} 
				} 
				if (done == true) 
				break; 
			} 
		} 
		 
		public void findTurnAroundTime(ArrayList<Integer> p, int n,ArrayList<Integer> bt, int wt[], int tat[])  						
		{ 
			for (int i = 0; i < n ; i++) 
				tat[i] = bt.get(i) + wt[i]; 
		} 
		
 
		public float findWTavgTime(int[] wt,int n) 									 
		{ 
			int total_wt = 0;
			for (int i=0; i<n; i++) 
			{ 
				total_wt = total_wt + wt[i]; 	
			}
			return (float)total_wt/n;
		} 
		public float findTATavgTime(int[] tat,int n) 									 
		{
			int total_tat = 0; 
			for (int i=0; i<n; i++) 
			{ 
				total_tat = total_tat + tat[i]; 
			}
			return (float)total_tat/n;
		}
		
}
