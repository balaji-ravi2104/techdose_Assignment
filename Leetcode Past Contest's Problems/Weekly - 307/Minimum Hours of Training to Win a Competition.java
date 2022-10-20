class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int sum = 0;
        int res = 0;
		//the energy needed is the total sum 
        for (int i : energy) {
            sum += i;
        }
        res += sum - initialEnergy >= 0 ? sum - initialEnergy + 1: 0;
        // if curExp < opponents‘ exp, we need to study to earn more
        for (int i : experience) {
            if (initialExperience <= i) {
                res += i - initialExperience + 1;
                initialExperience = i + 1;
            }
            initialExperience += i;
        }
        return res;
    }
}
