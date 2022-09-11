package BeginersProblem;

import java.util.*;
// 2 6 1 8 0 4 2
public class secondLargestNum {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int first=arr[0],second=arr[0];
        for(int i=0;i<n;i++){
            if(first < arr[i]){
                second =first;
                first =arr[i];
            }
            else if(second < arr[i] && arr[i]!=first){
                    second=arr[i];
                }
        }
        System.out.println("Second Maximum = "+second);
    }
}
