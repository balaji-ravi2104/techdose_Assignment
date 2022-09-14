/* Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
*/

class Solution {
    public boolean isPalindrome(int x) {
        int temp=x,sum=0,rem;
        while(x>0){
            rem=x%10;
            sum=(sum*10)+rem;
            x/=10;
        }
        return sum==temp;
    }
}
