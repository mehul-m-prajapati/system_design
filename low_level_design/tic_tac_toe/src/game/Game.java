package game;

import java.util.Deque;
import java.util.LinkedList;

import model.Board;
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
		Player player2 = new Player("mehul", zeroPiece);
		
		players.add(player1);
		players.add(player2);
		
		gameBoard = new Board(3);
		
	}
	
	public String startGame() {
		boolean noWinner = true;
		
		while (noWinner) {
			
			Player playerTurn = players.removeFirst();
			gameBoard.printBoard();
		}
		
		return "";
	}

}
