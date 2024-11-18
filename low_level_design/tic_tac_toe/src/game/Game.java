package game;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javafx.util.Pair;
import model.Board;
import model.PieceType;
import model.Player;
import model.PlayingPieceX;
import model.PlayingPieceO;

public class Game {
	
	Deque<Player> players;
	Board gameBoard;
	
	public Game() {
		initGame();
	}
	
	public void initGame() {
		players = new LinkedList<>();
		
		PlayingPieceX crossPiece = new PlayingPieceX();
		Player player1 = new Player("mehul", crossPiece);

		PlayingPieceO zeroPiece = new PlayingPieceO();
		Player player2 = new Player("karan", zeroPiece);
		
		players.add(player1);
		players.add(player2);
		
		gameBoard = new Board(3);
		
	}
	
	public String startGame() {
		boolean noWinner = true;
		
		while (noWinner) {
			
			Player currentPlayer = players.removeFirst();
			gameBoard.printBoard();
			
			// Get free cells from board
			List<Pair<Integer, Integer>> freeCells = gameBoard.getFreeCells();
			if (freeCells.isEmpty()) {
				noWinner = false;
				continue;
			}
			
			// user input for position of piece
            System.out.print("Player:" + currentPlayer.name + " Enter row,column: ");
            Scanner sc = new Scanner(System.in);
            String pos = sc.nextLine();
            String val[] = pos.split(",");
            int row = Integer.valueOf(val[0]);
            int col = Integer.valueOf(val[1]);
            
            // place the piece on board
            boolean isPlaced = gameBoard.addPiece(row, col, currentPlayer.getPlayingPiece());
            
            if (!isPlaced) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(currentPlayer);
                continue;
            }
            
            players.addLast(currentPlayer);
            
            boolean winner = isThereWinner(row, col, currentPlayer.playingPiece.pieceType);
            
            if (winner) {
            	gameBoard.printBoard();
            	return currentPlayer.name;
            }
		}
		
		return "tie";
	}
	
    public boolean isThereWinner(int row, int column, PieceType pieceType) {

    	int idx, jdx = 0;
    	
        // need to check in row
        for (idx = 0; idx < gameBoard.size; idx++) {
        	        	
        	if (gameBoard.board[row][idx] == null) 
        		break;
        	
        	if (gameBoard.board[row][idx].pieceType != pieceType)
        		break;        	
        }
        
        if (idx == gameBoard.size) {
        	System.out.println("Row: " + row +  " matched");
        	return true;
        }
        
        // need to check in column
        for (idx = 0; idx < gameBoard.size; idx++) {
        	
        	if (gameBoard.board[idx][column] == null)
        		break;
        	
	        if (gameBoard.board[idx][column].pieceType != pieceType)
	        	break;
        }
        
        if (idx == gameBoard.size) {
        	System.out.println("column: " + column +  " matched");
        	return true;
        }
        
        // need to check diagonals
        for (idx = 0, jdx = 0; idx < gameBoard.size; idx++, jdx++) {
        	
        	if (gameBoard.board[idx][jdx] == null)
        		break;
        	
	        if (gameBoard.board[idx][jdx].pieceType != pieceType)
	        	break;
        }
        
        if (idx == gameBoard.size) {
        	System.out.println("Diagnoal matched");
        	return true;
        }
        
        // need to check anti-diagonals
        for (idx = 0, jdx = gameBoard.size - 1; idx < gameBoard.size; idx++, jdx--) {
        	
        	if (gameBoard.board[idx][jdx] == null)
        		break;
        	
	        if (gameBoard.board[idx][jdx].pieceType != pieceType)
	        	break;
        	
        }
        
        if (idx == gameBoard.size) {
        	System.out.println("Anti-Diagnoal matched");
        	return true;
        }
    	
    	return false;
    }

}
