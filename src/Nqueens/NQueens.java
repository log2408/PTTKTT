package Nqueens;

public class NQueens {
	private int N;
	private SolutionN solution;
	public NQueens(int n) {
        this.N = n;
        this.solution = new SolutionN();
    }
	private boolean isSafe(int row, int col, int[][] board) {
		for(int i = 0; i < col; i++) {
			if(board[row][i] == 1) return false;
		}
		for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j] == 1) return false;
		}
		for(int i = row, j = col; i < N && j >= 0; i++, j--) {
			if(board[i][j] == 1) return false;
		}
		return true;
	}
	private boolean solveNQUtil(int col, int[][] board) {
		if(col >= N) {
			int[][] tmp = new int[N][N];
	        for (int i = 0; i < N; i++) {
	            System.arraycopy(board[i], 0, tmp[i], 0, N);
	        }
	        this.solution.addSolution(tmp);
	        return true;
		}
		boolean res = false;
		for(int i = 0; i < N; i++) {
			if(this.isSafe(i, col, board)) {
				board[i][col] = 1;
				if(solveNQUtil(col + 1, board)) res = true;
				board[i][col] = 0;
			}
		}
		return res;
	}
	public void solve() {
		int board[][] = new int[N][N];  
	    if (solveNQUtil(0, board) == false)  
	    {  
	        System.out.printf("Solution does not exist");  
	        return ;  
	    }  
	    return ;
    }
	public void printResults() {
        solution.printSolutions();
    }
}
