package chessGameTQS;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
	
	
	public Knight(int player) {
		this.name = "Caballo";
		this.player = player;}
	public List<Square> getPossibleMoves(Board b, int r, int c) {
		
		int row = r, col = c;
		List<Square> list = new ArrayList<Square>();
		
			// Arriba - Arriba - Izquierda
		
			row--;
			row--;
			col --;
		
					/* Logica movimiento */
			
					if (row >= 0 && col >=0) {
						
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
			
			
			
			row = r;
			col = c;
			
			
			// Arriba - Arriba - Derecha
			
			row--;
			row--;
			col ++;
			
					/* Logica movimiento */
			
					if (row >= 0 && col < b.NUM_COLS) {
						
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
		
			row = r;
			col = c;
			
			// Derecha - Derecha - Arriba
			
			col++;
			col++;
			row--;
			
					/* Logica movimiento */
			
					if (row >= 0 && col < b.NUM_COLS) {
						
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
			
			row = r;
			col = c;
			
			
		
		
			// Derecha - Derecha - Abajo
			
			col++;
			col++;
			row++;
			
					/* Logica movimiento */
			
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
			
			row = r;
			col = c;
		
			
			// Izquierda - izquierda - Arriba
			
			
			col--;
			col--;
			row--;
			
					/* Logica movimiento */
			
				
					if (row < b.NUM_ROWS && col >=0) {
									
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
			
			row = r;
			col = c;
			
			// Izquierda - izquierda - Abajo
			
			col--;
			col--;
			row++;
			
					/* Logica movimiento */
			
						if (row < b.NUM_ROWS && col >=0) {
							
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
			
			row = r;
			col = c;
				
			
			// Abajo - Abajo - Izquierda
		
			
			row++;
			row++;
			col--;
			
					/* Logica movimiento */
			
				if (row < b.NUM_ROWS && col >=0) {
					
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
			
			row = r;
			col = c;
			
			
			// Abajo - Abajo - Derecha
			
			row++;
			row++;
			col++;
			
					/* Logica movimiento */
			
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
			
			row = r;
			col = c;
		
		

		return list;
	};
}
