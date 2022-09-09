import java.util.*;
public class Main
{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n=sc.nextInt();
	//TC:O(N)
	List<Integer> list = new LinkedList<>();
	for(int i=1;i<=n;i++){
	    if(n%i==0){
	        list.add(i);
	    }
	}
	for(int i=0;i<list.size();i++){
	    System.out.print(list.get(i)+" ");
	}
	System.out.println();
	//TC O(root(N))
	List<Integer> lst = new LinkedList<>(); 
	for(int i=1;i*i<=n;i++){
	    if(n%i==0){
	        lst.add(i);
	        if(n/i!=i){
	            lst.add(n/i);
	        }
	    }
	}
	for(int i=0;i<lst.size();i++){
	System.out.print(lst.get(i)+" ");
	}
	}
}
