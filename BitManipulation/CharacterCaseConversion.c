#include <stdio.h>
#include<stdlib.h>

int main()
{
    char c;
    scanf("%c",&c);
    
    //toggle character case
    printf("%c\n",c^(1<<5));
    
    //convert to lowercase
    printf("%c\n",c|(1<<5));
    
    //convert to uppercase
    printf("%c\n",c&(~(1<<5)));
}
