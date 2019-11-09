package chessGameTQS;

public class MockGame extends Game {

	int n = 0;
	char[] chars = { 'd', 'p', 's', 's', 'a', 'p' };

	public char getInput() {

		return chars[n++];
	}
}
