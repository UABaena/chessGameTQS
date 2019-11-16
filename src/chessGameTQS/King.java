package chessGameTQS;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	public King(int player) {
		this.name = "Rey";
		this.player = player;
	}
	
	
	@Override
	public String toString() {
		
		return (this.player == Board.PLAYER_1)?"K":"k";
	
	}
	
	public List<Square> getPossibleMoves(Board b, int r, int c) {

		int row = r, col = c;
		List<Square> list = new ArrayList<Square>();


		// Probar Arriba
		row--;
		
		
		if (row >=0 ) {
			
			Square s = b.getSquare(row, col);
			Piece p = s.getPiece();

			if (p == null) { // Casilla vacia
				list.add(s);
			} else {

				if (p.getPlayer() != this.player) { // Otro jugador
					list.add(s);
				}
			}
			

		}
		
		// Probar Abajo
		row = r;
		col = c;
		
		row++;
		
		if (row < b.NUM_ROWS ) {
			Square s = b.getSquare(row, col);

			Piece p = s.getPiece();


			if (p == null) { // Casilla vacia
				list.add(s);

			} else {

				if (p.getPlayer() != this.player) { // Otro jugador
					list.add(s);
				}
			}

		}
		
		
		// Probar Izquierda
		row = r;
		col = c;
		
		col--;

		if (col >= 0) {
			Square s = b.getSquare(row, col);

			Piece p = s.getPiece();



			if (p == null) { // Casilla vacia
				list.add(s);
	
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

		if ( col < b.NUM_COLS ) {
			Square s = b.getSquare(row, col);

			Piece p = s.getPiece();

	

			if (p == null) { // Casilla vacia
				list.add(s);
	
			} else {

				if (p.getPlayer() != this.player) { // Otro jugador
					list.add(s);
				}
			}
			

		}
		
		// Probar Arriba-Izquierda
		row = r;
		col = c;
		
		row--;
		col--;

		
		if(row >= 0 && col >= 0 ) {
			Square s = b.getSquare(row, col);

			Piece p = s.getPiece();

	

			if (p == null) { // Casilla vacia
				list.add(s);

			} else {

				if (p.getPlayer() != this.player) { // Otro jugador
					list.add(s);
				}
			}


		}
		
		
		
		// Probar Arriba-Derecha
		row = r;
		col = c;
		
		row--;
		col++;
		
		if(row >= 0 && col < b.NUM_COLS) {
			Square s = b.getSquare(row, col);

			Piece p = s.getPiece();



			if (p == null) { // Casilla vacia
				list.add(s);

			} else {

				if (p.getPlayer() != this.player) { // Otro jugador
					list.add(s);
				}
			}


		}
		
		
		// Probar Abajo-Izquierda
		row = r;
		col = c;
		
		row++;
		col--;
		
		
		if (row < b.NUM_ROWS && col >= 0 ) {
			Square s = b.getSquare(row, col);

			Piece p = s.getPiece();

	

			if (p == null) { // Casilla vacia
				list.add(s);
		
			} else {

				if (p.getPlayer() != this.player) { // Otro jugador
					list.add(s);
				}
			}


		}
		
		// Probar Abajo-Derecha
		row = r;
		col = c;
		
		row++;
		col++;

		
		if (row < b.NUM_ROWS && col < b.NUM_COLS) {
			Square s = b.getSquare(row, col);

			Piece p = s.getPiece();

			

			if (p == null) { // Casilla vacia
				list.add(s);
	
			} else {

				if (p.getPlayer() != this.player) { // Otro jugador
					list.add(s);
				}
			}

		}
		
		
		
		
		return list;
	};
}
