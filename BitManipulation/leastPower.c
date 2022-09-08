#include<stdio.h>
#include<stdlib.h>
// Method 1
// TC: O(log(n))
int leastPower1(int n)
{
  while(n && n&(n-1)){
    n=n&(n-1);
  }
  return n;
}
// Method 2
// TC: O(log(n))
int leastPower2(int n){
  int ctr=0;
  while(n!=1){
    n>>=1;
    ctr++;
  }
  return 1<<ctr;
}
int main()
{
  int n;
  scanf("%d",&n);
  printf("%d\n",leastPower1(n));
  printf("%d\n",leastPower2(n));
}
