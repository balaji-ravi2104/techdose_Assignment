class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] arr = sentence.split(" ");
        for(int i=0;i<arr.length;i++){
            if(arr[i].charAt(0)!='$' || arr[i].length()<2)
                continue;
            long a=0;
            boolean flag=true;
            for(int j=1;j<arr[i].length();j++){
                char c=arr[i].charAt(j);
                if(Character.isDigit(c)){
                    a=a*10;
                    a+=(c-'0');
                }else{
                    flag=false;
                    break;
                }
            }
            if(flag){
                double d=a*0.01*discount;
                d=(double)a-d;
                arr[i]="$"+String.format("%.2f",d);
            }
        }
        return String.join(" ",arr);
    }
}
