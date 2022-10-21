class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int prev = 0;
        for (int[] bracket : brackets) {
            int upper = bracket[0], percent = bracket[1];
            if (income >= upper) {
                tax += (upper - prev) * percent / 100d;
                //System.out.println(tax);
                prev = upper;
            }else {
                tax += (income - prev) * percent / 100d;
                //System.out.println(tax);
                return tax;
            } 
        }
        return tax;
    }
}
