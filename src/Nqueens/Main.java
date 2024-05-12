package Nqueens;

public class Main {
	public static void main(String[] args) {
        int n = 8;
        NQueens nQueens = new NQueens(n);
        nQueens.solve();
        nQueens.printResults();
    }
}