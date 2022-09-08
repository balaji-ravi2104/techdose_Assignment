#include<stdio.h>
#include<stdlib.h>
int isSetBit(int n,int pos)
{
  return (n & (1<<(pos-1) ))!=0;
}
int main(){
  int n,pos;
  scanf("%d %d",&n,&pos);
  printf("%d",isSetBit(n,pos));
}
