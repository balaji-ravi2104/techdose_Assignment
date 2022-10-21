class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> odd = new PriorityQueue<>();
        PriorityQueue<Integer> even = new PriorityQueue<>();
        String str = Integer.toString(num);
        for(int i=0;i<str.length();i++){
            int digit = str.charAt(i)-'0';
            if(digit % 2==1)
                odd.add(digit);
            else
                even.add(digit);
        }
        StringBuilder sb = new StringBuilder();
        while(num>0){
            int cur = num%10;
            if(cur%2==1)
                sb.insert(0,odd.poll());
            else
                sb.insert(0,even.poll());
            num /= 10;
        }
        return Integer.parseInt(sb.toString());
    }
}
