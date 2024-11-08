import java.util.Scanner;
public class Kanpsackdp {
	public static int knapsack(int[] weight,int[] value, int capacity) {
		int n=weight.length;
		int [] [] dp=new int[n+1][capacity+1];
		for(int i=1;i<=n;i++) {
			for(int w=1;w<=capacity;w++) {
				if(weight[i-1]<w) {
					dp[i][w]=Math.max(value[i-1]+dp[i-1][w-weight[i-1]],dp[i-1][w]);
				}else {
					dp[i][w]=dp[i-1][w];
				}
			}
		}return dp[n][capacity];
	}


public static void main(String args[]) {
	Scanner scanner=new Scanner(System.in);
	System.out.print("Enter total number of elements: ");
	int n=scanner.nextInt();
	int[] weight=new int[n];
	int[] value=new int[n];
	System.out.print("Enter weight for elements:");
	for(int i=0;i<n;i++) {
		weight[i]=scanner.nextInt();
	}
	
	System.out.print("Enter value for elements:");
	for(int i=0;i<n;i++) {
		value[i]=scanner.nextInt();
	}
	
	System.out.print("enter capacuty: ");
	int capacity=scanner.nextInt();
	
	int max= knapsack(weight,value,capacity);
	System.out.print("Profit here is"+max);
	
	scanner.close();

}
}
