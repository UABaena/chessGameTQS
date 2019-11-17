package chessGameTQS;

import java.util.List;
import java.util.ArrayList;

public class Pawn extends Piece {

	public Pawn(int player) {
		this.name = "Peon";
		this.player = player;
	}

	@Override
	public String toString() {

		return (this.player == Board.PLAYER_1) ? "P" : "p";

	}

	public List<Square> getPossibleMoves(Board b, int r, int c) {
		
		

		List<Square> list = new ArrayList<Square>();
		
		
		if (r < 0 || r >= Board.NUM_ROWS || c < 0 || c >= Board.NUM_ROWS) {
			
			return null;
			
		}else {
			
			
		
		
		int row = r, col = c;

		if (this.player == b.PLAYER_1) {

			// Comprovar posicion inicial
			if (row == 1) {
				// Obtener las dos de delante y comprovar si se pueden mover
				Square s = b.getSquare(row + 1, col);

				if (s.getPiece() == null) {// Miramos si puede saltar a la primera casilla
					list.add(s);

					s = b.getSquare(row + 2, col);// Miramos si puede saltar a la segunda casilla
					if (s.getPiece() == null) {
						list.add(s);
					}
				}

			} else// Comprovar posicion generica
			{

				if (row < b.NUM_ROWS - 1) {

					Square s = b.getSquare(row + 1, col);

					if (s.getPiece() == null) {// Miramos si puede saltar a la siguiente casilla
						list.add(s);
					}

				}
			}
			// Comprovar si puede comer en diagonal
			if (row < b.NUM_ROWS - 1 && col < b.NUM_ROWS - 1) {
				Square s = b.getSquare(row + 1, col + 1);

				if (s.getPiece() != null) {
					if (s.getPiece().getPlayer() == b.PLAYER_2) {// Mirar si puede comer en diagonal
						list.add(s);
					}
				}
			}
			if (row < b.NUM_ROWS - 1 && col > 0) {
				Square s = b.getSquare(row + 1, col - 1);

				if (s.getPiece() != null) {
					if (s.getPiece().getPlayer() == b.PLAYER_2) {// Mirar si puede comer en diagonal
						list.add(s);
					}
				}
			}

		} else {// PLAYER_2

			// Comprovar posicion inicial
			if (row == 6) {
				// Obtener las dos de delante y comprovar si se pueden mover
				Square s = b.getSquare(row - 1, col);

				if (s.getPiece() == null) {// Miramos si puede saltar a la primera casilla
					list.add(s);

					s = b.getSquare(row - 2, col);// Miramos si puede saltar a la segunda casilla
					if (s.getPiece() == null) {
						list.add(s);
					}
				}

			} else// Comprovar posicion generica
			{

				if (row > 0) {

					Square s = b.getSquare(row - 1, col);

					if (s.getPiece() == null) {// Miramos si puede saltar a la siguiente casilla
						list.add(s);
					}

				}
			}
			// Comprovar si puede comer en diagonal
			if (row > 0 && col < b.NUM_ROWS - 1) {
				Square s = b.getSquare(row - 1, col + 1);
				Piece p = s.getPiece();

				if (p != null) {

					if (s.getPiece().getPlayer() == b.PLAYER_1) {// Mirar si puede comer en diagonal
						list.add(s);
					}
				}

			}
			if (row > 0 && col > 0) {
				Square s = b.getSquare(row - 1, col - 1);
				Piece p = s.getPiece();

				if (p != null) {

					if (s.getPiece().getPlayer() == b.PLAYER_1) {// Mirar si puede comer en diagonal
						list.add(s);
					}
				}
			}
		}

		return list;

	}}

}
