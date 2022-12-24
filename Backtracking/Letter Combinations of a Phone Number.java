class Solution {
    public List<String> letterCombinations(String digits) {
        String[] arr = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        StringBuilder sb = new StringBuilder();
        solve(digits,arr,0,res,sb);
        return res;
    }
    private void solve(String digits,String[] arr,int i,List<String> res,StringBuilder sb){
        if(i==digits.length()){
            res.add(sb.toString());
            return;
        }
        int pos = digits.charAt(i) - '0'; 
        for(int k=0;k<arr[pos-2].length();k++){
            sb.append(arr[pos-2].charAt(k));
            //System.out.print(sb.toString()+" ");
            solve(digits,arr,i+1,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/
