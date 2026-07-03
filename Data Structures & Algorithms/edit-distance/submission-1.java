class Solution {
    private int[][] array;
    public int minDistance(String word1, String word2) {
        int a = word1.length();
        int b = word2.length();
        array = new int[a][b];

        for(int i = 0; i < a; i++){
            for(int j = 0; j < b;j++){
                array[i][j] = -1;
            }
        }

        return dfs(0, 0, word1, word2, a, b);
    }
    private int dfs(int i, int j, String word1, String word2, int a, int b){
        if(i == a){
            return b - j;
        }
        if(j == b){
            return a - i;
        }
        if(array[i][j] != -1){
            return array[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            array[i][j] = dfs(i+1, j+1, word1, word2, a, b);
        } else{
        int result = Math.min(dfs(i+1, j, word1, word2, a, b), dfs(i , j+1, word1, word2, a, b));
        result = Math.min(result, dfs(i + 1, j+ 1, word1, word2, a, b));
        array[i][j] = result + 1;
        }
        return array[i][j];
    }
}
