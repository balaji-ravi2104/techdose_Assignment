import java.util.*;
public class Main
{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N=sc.nextInt();
	int R=sc.nextInt();
	System.out.println("OutPut :"+toFind(N,R));
	}
	public static int toFind(int n,int r){
	    return fact(n)/(fact(r)*fact(n-r));
	}
	public static int fact(int n){
	    if(n==0){
	        return 1;
	    }
	    int res=1;
	    for(int i=2;i<=n;i++){
	        res*=i;
	    }
	    return res;
	}
}
