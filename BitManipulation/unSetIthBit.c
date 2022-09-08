#include<stdio.h>
#include<stdlib.h>
int UnSetIthBit(int n,int pos)
{
  return n & (~(1<<(pos-1)));
}
int main()
{
  int n,pos;
  scanf("%d %d",&n,&pos);
  printf("%d",UnSetIthBit(n,pos));
  return 0;
}
