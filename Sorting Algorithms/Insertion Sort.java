import java.util.*;
public class Main{
  public static void main(String args[]){
  Scanner sc = new Scanner(System.in);
  int n=sc.nextInt();
  int[] arr = new int[n];
  for(int i=0;i<n;i++){
   arr[i]=sc.nextInt();
  }
  List<Integer> list = new ArrayList<Integer>();
  for(int i=0;i<n;i++){
    list.add(arr[i]);
    for(int j=list.size()-1;j>0;j--){
      if(list.get(j)>=list.get(j-1)){
        break;
      }
      Collections.swap(list,j,j-1);
    }
  }
  for(int i=0;i<n;i++){
    System.out.print(list.get(i)+" ");
  }
  }
}


// Time Complexity
// BC : O(N) --> Already Sorted Order
// WC : O(N^2) --> Descending Order
// AC : O(N^2) --> Random Order
