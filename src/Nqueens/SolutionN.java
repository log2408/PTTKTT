package Nqueens;

import java.util.ArrayList;

public class SolutionN {
	private ArrayList<int[][]> solutions;
	public SolutionN() {
		this.solutions = new ArrayList<int[][]>();
	}
	public void addSolution(int[][] solution) {
        solutions.add(solution);
    }
	public void printSolutions() {
        System.out.println("Total solutions: " + solutions.size());
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("Solution " + (i + 1) + ":");
            printBoard(solutions.get(i));
            System.out.println();
        }
    }
	private void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }
}
