class Solution {
    public int percentageLetter(String s, char letter) {
        int count=0,len=s.length();
        for(char c:s.toCharArray()){
            if(c==letter)
                count++;
        }
        double d=(double)count/len;
        System.out.println(d);
        double ans=d*100;
        return (int)ans;
    }
}
