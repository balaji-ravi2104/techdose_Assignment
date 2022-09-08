#include<stdio.h>
#include<stdlib.h>
int rightMostOne(int n)
{
  return n & (~n+1);
}
int rightMostOnePosition(int n)
{
  int pos=0;
  while((n&1)!=0){
    n>>=1;
    pos++;
  }
  return pos+1;
}
int main()
{
  int n;
  scanf("%d",&n);
  printf("%d\n",rightMostOne(n));
  printf("%d\n",rightMostOnePosition(n));
}
