class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=0;i<=num;i++){
            int val=reverse(i);
            if(i+val == num)
                return true;
        }
        return false;
    }
    public static int reverse(int num){
        String s=Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);
        String str=sb.reverse().toString();
        int n=Integer.parseInt(str);
        return n;
    }
}
