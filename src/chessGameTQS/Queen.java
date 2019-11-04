package chessGameTQS;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
	public Queen(int player) {
		this.name = "Reina";
		this.player = player;
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
		
		// Probar Arriba-Izquierda
		row = r;
		col = c;
		
		row--;
		col--;
		continueAdding = true;
		
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

}
