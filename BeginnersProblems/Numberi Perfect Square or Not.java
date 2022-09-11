import java.util.*;
class Main{
  public static void main(String Arg[]){
    Scanner sc= new Scanner(System.in);
      int n=sc.nextInt();
      System.out.println(isperfectSquare(n));
  }
    public static boolean isperfectSquare(int x)
    {
        if (x >= 0) {
            int sr = (int)Math.sqrt(x);
            return ((sr * sr) == x);
        }
        return false;
    }
}
