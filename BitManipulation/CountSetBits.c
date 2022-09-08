#include <stdio.h>
#include<stdlib.h>

int main()
{
    int n;
    scanf("%d",&n);
    int count=0;
    
    for(int i=0;(n>>i)!=0;i++){
        if(n&(1<<i)){
            count++;
        }
    }
    printf("%d",count);
    return 0;
}
