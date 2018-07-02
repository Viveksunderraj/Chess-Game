
public class Bishop extends Piece {
	

	public Bishop(Color color, Location location, PieceType type) {
		super(color, location, type);
		
	}
	
	public enum Direction {
		TOP_RIGHT, TOP_LEFT, BOTTOM_LEFT, BOTTOM_RIGHT;
	}

	@Override
	boolean isValidMove(int[] source, int[] destination, Color playerColor) {
		int moveFromX = source[0];
		int moveFromY = source[1];
		int moveToX = destination[0];
		int moveToY = destination[1];
		
		Square fromSquare = ChessBoard.getSquare(moveFromY, moveFromX);
		Square toSquare = ChessBoard.getSquare(moveToY, moveToX);
		
		Direction direction = null;
		
		if(moveToX > moveFromX){
			if(moveToY < moveFromY){
				direction = Direction.TOP_RIGHT;
			}
			else{
				direction = Direction.BOTTOM_RIGHT;
			}
		}
		else if(moveToY != moveFromY){
			if(moveToY < moveFromY){
				direction = Direction.TOP_LEFT;
			}
			else{
				direction = Direction.BOTTOM_LEFT;
			}
		}
		else {
			return false;
		}
		
		
		Square testSquare = null;
		int distanceToCover = Math.abs(moveToX - moveFromX);
		
		for(int diagDistance = 1; diagDistance <= distanceToCover; diagDistance++){
			
			if(direction == Direction.TOP_RIGHT){
				testSquare = ChessBoard.getSquare(moveFromY - diagDistance, moveFromX + diagDistance);
			}
			else if(direction == Direction.BOTTOM_RIGHT){
				testSquare = ChessBoard.getSquare(moveFromY + diagDistance, moveFromX + diagDistance);
			}
			else if(direction == Direction.TOP_LEFT){
				testSquare = ChessBoard.getSquare(moveFromY - diagDistance, moveFromX - diagDistance);
			}
			else if(direction == Direction.BOTTOM_LEFT){ 
				testSquare = ChessBoard.getSquare(moveFromY + diagDistance, moveFromX - diagDistance);
			}
			
			
			if((testSquare.getPiece().getPieceType() != PieceType.BLANK_PIECE) && (diagDistance != distanceToCover)){
				return false;
			}
			else if((diagDistance == distanceToCover) && ((testSquare.getPiece().getPieceType() == PieceType.BLANK_PIECE))){
				return true;
			}
			else if((diagDistance == distanceToCover) && (testSquare.getPiece().getColor() != playerColor)) {
				isGameOver(toSquare);
				displayCutMessage(fromSquare, toSquare);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		if(color == Color.BLACK)
			return "BB ";
		else 
			return "WB ";
	}
	
	

}
