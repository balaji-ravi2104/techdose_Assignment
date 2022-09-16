import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
		    arr[i]=sc.nextInt();
		}
		int[] ans = countSort(arr);
		//System.out.println(Arrays.toString(ans));
		for(int i:ans)
		{
		    System.out.print(i+" ");
		}
	}
	public static int[] countSort(int[] arr){
	    int max=arr[0];
	    for(int i=1;i<arr.length;i++){
	        max=Math.max(max,arr[i]);
	    }
	    int[] hash = new int[max+1];
	    for(int i:arr){
	        hash[i]++;
	    }
	    for(int i=1;i<=max;i++){
	        hash[i]+=hash[i-1];
	    }
	    //System.out.println(Arrays.toString(hash));
	    // always traverse from right to left...
	    int[] result = new int[arr.length];
	    for(int i=arr.length-1;i>=0;i--){
	        result[--hash[arr[i]]]=arr[i];
	    }
	    return result;
	}
}

