package chessGameTQS;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
	public Rook(int player) {
		this.name = "Torre";
		this.player = player;
	}

	@Override
	public String toString() {

		return (this.player == Board.PLAYER_1) ? "R" : "r";

	}

	public List<Square> getPossibleMoves(Board b, int r, int c) {

		int row = r, col = c;
		List<Square> list = new ArrayList<Square>();

		// Probar Arriba
		row--;
		boolean continueAdding = true;

		while (row >= 0 && continueAdding) {
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

		}

		// Probar Abajo
		row = r;
		col = c;

		row++;
		continueAdding = true;
		while (row < b.NUM_ROWS && continueAdding) {
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

		}

		// Probar Izquierda
		row = r;
		col = c;

		col--;
		continueAdding = true;
		while (col >= 0 && continueAdding) {
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
			col--;

		}

		// Probar Derecha
		row = r;
		col = c;

		col++;
		continueAdding = true;
		while (row < b.NUM_COLS && continueAdding) {
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
			col++;

		}

		return list;
	};

}
