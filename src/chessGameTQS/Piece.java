package chessGameTQS;

import java.util.List;

public abstract class Piece {

	private String player;
	private String name;
	public abstract List<Square> getPossibleMoves(Board b);
	
}
