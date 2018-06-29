
public class King extends Piece {

	
	
	public King(Color color, Location location, PieceType type) {
		super(color, location, type);
		
	}

	@Override
	boolean isValidMove(int[] source, int[] destination, Color playerColor) {

		int moveFromX = source[0];
		int moveFromY = source[1];
		int moveToX = destination[0];
		int moveToY = destination[1];
		
		Square fromSquare = ChessBoard.getSquare(moveFromY, moveFromX);
		Square toSquare = ChessBoard.getSquare(moveToY, moveToX);
		
		
		
		if(moveToX == moveFromX+1) {
			if(moveToY == moveFromY + 1 || moveToY == moveFromY || moveToY == moveFromY - 1) {
				if(toSquare.getPiece().getPieceType() == PieceType.BLANK_PIECE) {
					return true;
				}
				else if((toSquare.getPiece().getPieceType() != PieceType.BLANK_PIECE) && (toSquare.getPiece().getColor() != playerColor)) {
					displayCutMessage(fromSquare, toSquare);
					return true;
				}
				
			}
		}
		else if(moveToX == moveFromX) { 
			
			if(moveToY == moveFromY + 1 || moveToY == moveFromY - 1) {
				if(toSquare.getPiece().getPieceType() == PieceType.BLANK_PIECE) {
					return true;
				}
				else if((toSquare.getPiece().getPieceType() != PieceType.BLANK_PIECE) && (toSquare.getPiece().getColor() != playerColor)) {
					displayCutMessage(fromSquare, toSquare);
					return true;
				}
				
			}
		}
		else if(moveToX == moveFromX-1) {
			
			if(moveToY == moveFromY + 1 || moveToY == moveFromY || moveToY == moveFromY - 1) {
				if(toSquare.getPiece().getPieceType() == PieceType.BLANK_PIECE) {
					return true;
				}
				else if((toSquare.getPiece().getPieceType() != PieceType.BLANK_PIECE) && (toSquare.getPiece().getColor() != playerColor)) {
					displayCutMessage(fromSquare, toSquare);
					return true;
				}
				
			}
		}
		return false;
	}

	@Override
	public String toString() {
		if (color == Color.BLACK)
			return "BKi";
		else 
			return "WKi";
	}
	
	

}
