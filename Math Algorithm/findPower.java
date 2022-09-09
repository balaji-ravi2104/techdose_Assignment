import java.util.*;
public class Main
{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	long base=sc.nextInt();
	long power=sc.nextInt();
	System.out.println(getPower(base,power));   
	}
	public static long getPower(long base,long power){
	    long res=1;
	    while(power>0){
	        if(power%2==1){
	            res*=base;
	        }
	        base=base*power;
	        power/=2;
	    }
	    return res;
	}
}
