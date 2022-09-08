import java.util.*;
public class Main
{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println(isPrime1(n)?"Prime":"NotPrime");
    System.out.println(isPrime2(n)?"Prime":"NotPrime");
	}
  //TC : O(N)
	public static boolean isPrime1(int n){
	    for(int i=2;i<=n/2;i++){
	        if(n%i==0){
	            return false;
	        }
	    }
	    return true;
	}//TC : O(root(N))
	public static boolean isPrime2(int n){
	    for(int i=2;i*i<=n;i++){
	        if(n%i==0){
	            return false;
	        }
	    }
	    return true;
	}
}
