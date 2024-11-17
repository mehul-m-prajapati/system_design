package model;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class Board {
	
	public int size;
	public PlayingPiece[][] board;
	
	public Board(int size) {
		this.size = size;
		board = new PlayingPiece[size][size]; 
	}
	
    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {

    	if (board[row][column] != null )
    		return false;
    		
    	board[row][column] = playingPiece;
    	
    	return true;
    }
	
	public void printBoard() {
		for (int idx = 0; idx < size; idx++) {
			for (int jdx = 0; jdx < size; jdx++) {
				
				if (board[idx][jdx] != null)
					System.out.print(board[idx][jdx].pieceType.toString() + "  ");
				else
					System.out.print("  ");
				
	            System.out.print(" | ");
			}
            System.out.println();
		}
	}
	
	public List<Pair<Integer, Integer>> getFreeCells() {
		List<Pair<Integer, Integer>> freecells = new ArrayList<>();
		
		 for (int i = 0; i < size; i++) {
	            for (int j = 0; j < size; j++) {
	                if (board[i][j] == null)
	                	freecells.add(new Pair<>(i, j));
	            }
		 }

		return freecells;
	}
}
