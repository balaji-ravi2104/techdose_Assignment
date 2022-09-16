import java.util.*;
public class Main
{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n=sc.nextInt();
	int[] arr = new int[n];
	for(int i=0;i<n;i++){
	    arr[i]=sc.nextInt();
	}
	int[] ans=RadixSort(arr);
	System.out.println(Arrays.toString(ans));
	}
	public static int[] RadixSort(int[] arr){
	    int max=arr[0];
	    for(int i=1;i<arr.length;i++){
	        max=Math.max(arr[i],max);
	    }
	    int digits=(int)(Math.log(max)/Math.log(10));
	    for(int parse=0;parse<=digits;parse++){
	        int[] hash =new int[10];
	        for(int val:arr){
	            int ind=(val/(int)(Math.pow(10,parse)))%10;
	            hash[ind]++;
	        }
	        for(int i=1;i<10;i++){
	            hash[i]+=hash[i-1];
	        }
	        
	        int[] output = new int[arr.length];
	        for(int i=arr.length-1;i>=0;i--){
	            int ind=(arr[i]/(int)Math.pow(10,parse))%10;
	            output[--hash[ind]]=arr[i];
	        }
	        arr=output;
	    }
	    return arr;
	}
}
