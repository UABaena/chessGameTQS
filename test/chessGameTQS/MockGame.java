package chessGameTQS;

import java.util.List;

public class MockGame extends Game {

	int n = 0;
	char[] chars = { 'd', 'p', 's', 's', 'a', 'p' };

	public char getInput() {

		return chars[n++];
	}
	
	public boolean isJaque(Square dest) {
		
		
		int turnPlayer = board.getPlayerTurn();
				
				//Posibles movimientos de la pieza destino
				
				List<Square> result = board.getSquare(dest.getRow(), dest.getCol()).getPiece().getPossibleMoves(board, dest.getRow(), dest.getCol());
				
				//Busca el rey del jugador contrario
				
				Square sKing = new Square();
				
				for (int i = 0; i < board.NUM_ROWS; i++) {
					for (int j = 0; j < board.NUM_COLS; j++) {
						
						if (board.getSquare(i, j).getPiece() != null) {
							
							
							if (board.getSquare(i, j).getPiece().getName() == "Rey" && board.getSquare(i, j).getPiece().getPlayer() != turnPlayer){
								
								sKing = board.getSquare(i, j);
								
				
							}

							
						}
		
					}
					
				}
				
				if (sKing.getPiece() != null) {
					
					for (Square sAux : result) {
						
						
						if (sAux.equals(sKing)) {


							return true;
						}

					}
						
					
				}			
				return false;
			}
}
