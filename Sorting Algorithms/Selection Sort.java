import java.util.*;
public class Main
{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
		    arr[i] = sc.nextInt();
		}
		for(int i=0;i<n-1;i++)
		{
		    int Index = i;
		    for(int j=i+1;j<n;j++)
		    {
		        if(a[Index] > a[j])
		        {
		            Index = j;
		        }
		    }
		    int temp = arr[Index];
		    arr[Index] = arr[i];
		    arr[i] = temp;
		}
		for(int i=0;i<n;i++)
		{
		    System.out.print(arr[i]+" ");
		}
	}
}

// Time Comlexity
// --------------

// BC : O(N^2)
// WC : O(N^2)	
