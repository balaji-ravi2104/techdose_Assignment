class Solution {
    public String addStrings(String nums1, String nums2) {
    int n1=nums1.length()-1;
    int n2=nums2.length()-1;
        int carry=0;
        StringBuilder sb = new StringBuilder();
        while(n1>=0 || n2>=0){
            int x=(n1>=0)?nums1.charAt(n1)-'0':0;
            int y=(n2>=0)?nums2.charAt(n2)-'0':0;
            int sum=x+y+carry;
            sb.append(sum%10);
            carry=sum/10;
            n1--;
            n2--;
        }
        if(carry>0)
            sb.append(carry);
        
        return sb.reverse().toString();
    }
}

/* 
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). 
You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
*/
