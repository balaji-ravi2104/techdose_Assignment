#include<stdio.h>
#include<stdlib.h>
int isPowerOf2(int n)
{
  return n>0 && (n&(n-1))==0;
}
int main(){
  int n;
  scanf("%d",&n);
  printf(isPowerOf2(n)?"True":"False");
  return 0;
}
