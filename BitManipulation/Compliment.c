#include<stdio.h>
int main(){
  int n;
  scanf("%d",&n);
  // once compliment just flip all
  printf("%d",~n);
  // tow's compliment
  printf("%d",(~n)+1);
  // once compliment of MSB
  for(int i=0;(n>>i)!=0;i++){
    n ^= 1<<i;
  }
  printf("%d",n);
  return 0;
}
