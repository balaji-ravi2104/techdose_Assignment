import java.util.*;
class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        System.out.print(findFact(n));
    }
    public static long findFact(int n){
      if(n==0)
        return 1;
      else
        return n*findFact(n-1);
    }
}
