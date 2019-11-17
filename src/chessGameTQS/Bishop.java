package chessGameTQS;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

	public Bishop(int player) {
		this.name = "Alfil";
		this.player = player;
	}

	@Override
	public String toString() {

		return (this.player == Board.PLAYER_1) ? "B" : "b";

	}

	public List<Square> getPossibleMoves(Board b, int r, int c) {

		if (r < 0 || r >= Board.NUM_ROWS || c < 0 || c >= Board.NUM_ROWS) {

			return null;

		} else {

			int row = r, col = c;
			List<Square> list = new ArrayList<Square>();

			// Probar Arriba-Izquierda
			row = r;
			col = c;

			row--;
			col--;
			boolean continueAdding = true;

			while (row >= 0 && col >= 0 && continueAdding) {
				Square s = b.getSquare(row, col);

				Piece p = s.getPiece();

				continueAdding = false;

				if (p == null) { // Casilla vacia
					list.add(s);
					continueAdding = true;
				} else {

					if (p.getPlayer() != this.player) { // Otro jugador
						list.add(s);
					}
				}
				row--;
				col--;

			}

			// Probar Arriba-Derecha
			row = r;
			col = c;

			row--;
			col++;
			continueAdding = true;

			while (row >= 0 && col < b.NUM_COLS && continueAdding) {
				Square s = b.getSquare(row, col);

				Piece p = s.getPiece();

				continueAdding = false;

				if (p == null) { // Casilla vacia
					list.add(s);
					continueAdding = true;
				} else {

					if (p.getPlayer() != this.player) { // Otro jugador
						list.add(s);
					}
				}
				row--;
				col++;

			}

			// Probar Abajo-Izquierda
			row = r;
			col = c;

			row++;
			col--;
			continueAdding = true;

			while (row < b.NUM_ROWS && col >= 0 && continueAdding) {
				Square s = b.getSquare(row, col);

				Piece p = s.getPiece();

				continueAdding = false;

				if (p == null) { // Casilla vacia
					list.add(s);
					continueAdding = true;
				} else {

					if (p.getPlayer() != this.player) { // Otro jugador
						list.add(s);
					}
				}
				row++;
				col--;

			}

			// Probar Abajo-Derecha
			row = r;
			col = c;

			row++;
			col++;
			continueAdding = true;

			while (row < b.NUM_ROWS && col < b.NUM_COLS && continueAdding) {
				Square s = b.getSquare(row, col);

				Piece p = s.getPiece();

				continueAdding = false;

				if (p == null) { // Casilla vacia
					list.add(s);
					continueAdding = true;
				} else {

					if (p.getPlayer() != this.player) { // Otro jugador
						list.add(s);
					}
				}
				row++;
				col++;

			}

			return list;
		}
	};
}
