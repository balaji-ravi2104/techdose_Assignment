class Solution {
    private final int mod = (int) Math.pow(10,9) + 7;

    public int[] productQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];
        List<Integer> powers = new ArrayList<>();
        int x = n;
        while (x>0) {
            int highestPower = (int) (Math.log(x)/Math.log(2));
            int pow = (int) Math.pow(2,highestPower);
            x = x - pow;
            powers.add(0,pow);
        }
        for (int j=0;j<queries.length;j++) {
            int start = queries[j][0];
            int end = queries[j][1];
            long r = 1;
            for (int i=start;i<=end;i++) {
                r = (r*powers.get(i))%mod;
            }
            result[j]=(int) (r%mod);
        }
        return result;
    }
}
