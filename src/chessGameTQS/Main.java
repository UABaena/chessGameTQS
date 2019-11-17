package chessGameTQS;

public class Main {

	int a;

	public static void main(String[] args) {
		Game g = new Game();
		g.printInstrucciones();

		while (!g.isFinished())
			g.playTurn();

		// Hay un ganador
		int winner = g.getWinner();
		System.out.println((winner == Board.PLAYER_1 ? "Player 1" : "Player 2") + " ha ganado.");
	}
}
