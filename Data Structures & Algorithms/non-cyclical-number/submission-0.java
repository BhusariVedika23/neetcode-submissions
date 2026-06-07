class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(!set.contains(n)){
            set.add(n);
            n = sumOfSquares(n);
            if(n == 1){
                return true;
            }
        }
        return false;
    }

    public int sumOfSquares(int n){
        int ans = 0;
        while(n > 0){
            int digit = n % 10;
            digit = digit * digit;
            ans += digit;
            n /= 10;
        }
        return ans;
    }
}
