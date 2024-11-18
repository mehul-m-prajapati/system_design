package game;

public class Main {

	public static void main(String args[]) {
		Game tictactoe = new Game();
		
		tictactoe.initGame();
		System.out.println("Game winner is " + tictactoe.startGame());
	}
}
