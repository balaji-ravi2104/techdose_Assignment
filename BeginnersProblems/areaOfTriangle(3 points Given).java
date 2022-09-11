import java.util.*;
class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int Ax,Bx,Cx,Ay,By,Cy;
        double A,B,C,side,area;
        Ax=sc.nextInt();
        Bx=sc.nextInt();
        Cx=sc.nextInt();
        Ay=sc.nextInt();
        By=sc.nextInt();
        Cy=sc.nextInt();
        A=Math.sqrt(((Bx-Ax)*(Bx-Ax))+((By-Ay)*(By-Ay)));
        B=Math.sqrt(((Cx-Bx)*(Cx-Bx))+((Cy-By)*(Cy-By)));
        C=Math.sqrt(((Ax-Cx)*(Ax-Cx))+((Ay-Cy)*(Ay-Cy)));
        side=(A+B+C)/2;
        area=Math.sqrt(side*(side-A)*(side-B)*(side-C));
        System.out.println("The Area of Triangle = "+area);
    }
}
