package chessGameTQS;

public class MockGame extends Game {

	int n = 0;
	String[] chars;

	public MockGame(String[] string) {

		chars = string;

	}

	public MockGame() {

	}

	public char getInput() {

		String s = chars[n++];

		if (s.length() > 1)
			return 'e';
		return s.charAt(0);
	}

}
