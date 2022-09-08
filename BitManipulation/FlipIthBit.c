#include<stdio.h>
#include<stdlib.h>
int flipIthbit(int n,int pos)
{
  return n ^(1<<(pos-1));
}
int main(){
  int n,pos;
  scanf("%d %d",&n,&pos);
  printf("%d",flipIthbit(n,pos));
}
