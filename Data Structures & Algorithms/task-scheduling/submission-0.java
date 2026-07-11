class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }
        Arrays.sort(count);
        int maxf = count[25];
        int ideal = (maxf - 1)*n;

        for(int i = 24; i>=0; i--){
            ideal -= Math.min(maxf - 1, count[i]);
        }
        return Math.max(0, ideal) + tasks.length; 
    }
}
