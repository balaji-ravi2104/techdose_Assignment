import java.util.*;
public class Main
{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println(isPerfectSquare(n));
	}
	static boolean isPerfectSquare(int n)
    {
        for (int i = 1; i * i <= n; i++) {
            if ((n % i == 0) && (n / i == i)) {
                return true;
            }
        }
        return false;
    }
}
