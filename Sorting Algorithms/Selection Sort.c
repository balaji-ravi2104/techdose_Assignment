#include<stdio.h>
#include<stdlib.h>
void selectionSort(int *arr,int n)
{
  for(int i=0;i<n-1;i++){
    int minIndex=i;
    for(int j=i+1;j<n;j++){
      if(arr[minIndex]>arr[j])
        minIndex=j;
    }
  int temp=arr[i];
  arr[i]=arr[minIndex];
  arr[minIndex]=temp;
  }
}
int main()
{
  int n;
  scanf("%d",&n);
  int arr[n];
  for(int i=0;i<n;i++)
  {
    scanf("%d",&arr[i]);
  }
  selectionSort(arr,n);
  for(int i=0;i<n;i++)
  {
    printf("%d ",arr[i]);
  }
}
