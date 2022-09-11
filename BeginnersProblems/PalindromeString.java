import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int len=str.length();
        int j = len-1;
        for(int i=0;i<=len/2;i++){
            if(str.charAt(i)!=str.charAt(j)){
                System.out.println("NO");
                System.exit(0);
            }
            j--;
        }
        System.out.println("YES");
    }
}
