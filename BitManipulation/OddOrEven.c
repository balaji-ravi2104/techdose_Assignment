#include<stdio.h>
#include<stdlib.h>
int OddOrEven(int n){
  return (n&1)!=0;
}
int main()
{
  int n;
  scanf("%d",&n);
  printf(OddOrEven(n)==1?"Odd":"Even");
  return 0;
}
