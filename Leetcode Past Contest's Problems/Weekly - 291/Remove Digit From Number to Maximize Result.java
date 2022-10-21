class Solution {
    public String removeDigit(String number, char digit) {
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<number.length();i++){
            if(number.charAt(i)==digit){
                String str=number.substring(0,i)+number.substring(i+1);
                list.add(str);
            }
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }
}
