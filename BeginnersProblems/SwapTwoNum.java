import java.util.*;
public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int a=sc.nextInt();
    int b=sc.nextInt();
    a^=b;
    b^=a;
    a^=b;
    System.out.println(a+" "+b);
  }
}
