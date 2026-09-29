class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2*n];

        backtrack(0, n, board, result, cols, diag1, diag2);
        return result;
    }

    public void backtrack(int row, int n, char[][] board, List<List<String>> result, boolean[] cols, boolean[] diag1, boolean[] diag2){

        if(row == n){
            result.add(constructBoard(board));
            return;
        }

        for(int col = 0; col < n; col++){
            int d1 = row - col + (n -1);
            int d2 = row + col;


            if(cols[col] || diag1[d1] || diag2[d2]){
                continue;
            }

            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row+1, n, board, result, cols, diag1, diag2);

            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    public List<String> constructBoard(char[][] board){
        List<String> list = new ArrayList<>();
        for(char[] row : board){
            list.add(new String(row));
        }

        return list;
    }
}
