package chessGameTQS;

import java.util.Scanner;

public class Main {

	int a;

	public static void main(String[] args) {
		Board b = new Board();

		b.printBoard();

		Scanner scan = new Scanner(System.in);
		while (true) {
			char key;
			System.out.println("Please Input either w, a, s, or d:");
			key = scan.next().charAt(0);

			switch (key) {

			case 'w':
				b.cursorUp();
				break;

			case 'a':
				b.cursorLeft();
				break;

			case 's':
				b.cursorDown();
				break;

			case 'd':
				b.cursorRight();
				break;
			case ' ':
				System.out.println("Enter!!");
				break;
			default:
				return;
			}

			b.printBoard();

		}
	}
}
