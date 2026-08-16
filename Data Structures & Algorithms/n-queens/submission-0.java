class Solution {
    boolean[] col, posD, negD;
    List<List<String>> result;
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        posD = new boolean[2 * n];
        negD = new boolean[2 * n];
        result = new ArrayList<>();
        board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        backtrack(0, n);
        return result;
    }
    private void backtrack(int r, int n){
        if(r == n){
            List<String> copy = new ArrayList<>();
            for(char[] row : board){
                copy.add(new String(row));
            }
            result.add(copy);
            return;
        }
        for(int c = 0; c < n; c++){
            if(col[c] || posD[r + c] || negD[ r - c + n]){
                continue;
            }
            
            col[c] = true;
            posD[r + c] = true;
            negD[ r - c + n] = true;
            board[r][c] = 'Q';
            backtrack(r + 1, n);

            col[c] = false;
            posD[r + c] = false;
            negD[r - c + n] = false;
            board[r][c] = '.';
            
        }
    }
}
