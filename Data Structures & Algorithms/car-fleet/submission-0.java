class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] z = new int[position.length][2];
        for(int i = 0; i< position.length;i++){
            z[i][0] = position[i];
            z[i][1] = speed[i];
        }
        Arrays.sort(z, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for(int[] p : z){
            stack.push((double) (target - p[0])/p[1]);
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)){
                stack.pop();
            }
        }
        return stack.size();
    }
}
