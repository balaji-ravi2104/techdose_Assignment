#include<stdio.h>
#include<stdlib.h>
int setIthBit(int n,int pos){
 // printf("%d\n",(1<<(pos-1)));
  return n | (1<<(pos-1) );
}
int main(){
  int n,pos;
  scanf("%d %d",&n,&pos);
  printf("%d",setIthBit(n,pos));
  return 0;
}
  
