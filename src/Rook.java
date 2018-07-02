
public class Rook extends Piece {

	
	
	public Rook(Color color, Location location, PieceType type) {
		super(color, location, type);
	}
	
	public enum Direction {
		RIGHT, LEFT, TOP, BOTTOM;
	}

	@Override
	boolean isValidMove(int[] source, int[] destination, Color playerColor) {
		int moveFromX = source[0];
		int moveFromY = source[1];
		int moveToX = destination[0];
		int moveToY = destination[1];
		
		Square fromSquare = ChessBoard.getSquare(moveFromY, moveFromX);
		Square toSquare = ChessBoard.getSquare(moveToY, moveToX);
		Direction direction;
		
		if(moveToY == moveFromY){
			if(moveToX > moveFromX){
				direction = Direction.RIGHT;
				//System.out.println("INSIDE RIGHT");
			}
			else{
				direction = Direction.LEFT;
				//System.out.println("INSIDE LEFT");
			}
		}
		
		else if(moveToX == moveFromX){
			if(moveToY > moveFromY){
				direction = Direction.BOTTOM;
				//System.out.println("INSIDE BOTTOM");
			}
			else{
				direction = Direction.TOP;
				//System.out.println("INSIDE TOP");
			}
		}
		else{
			return false;
		}
		
		int distanceToCover;
		
	if(direction == Direction.RIGHT || direction == Direction.LEFT) {
			distanceToCover = Math.abs(moveToX - moveFromX);
		}
		else {
			distanceToCover = Math.abs(moveToY - moveFromY);
		}
		
		Square testSquare = null;
		
		for(int distance = 1; distance <= distanceToCover; distance++) {
			
			if(direction == Direction.RIGHT){
				testSquare = ChessBoard.getSquare(moveFromY, moveFromX + distance);
			}
			else if(direction == Direction.LEFT){
				testSquare = ChessBoard.getSquare(moveFromY, moveFromX - distance);
			}
			else if(direction == Direction.TOP){
				testSquare = ChessBoard.getSquare(moveFromY - distance, moveFromX);
			}
			else if(direction == Direction.BOTTOM){ 
				testSquare = ChessBoard.getSquare(moveFromY + distance, moveFromX);
			}
			
			if((testSquare.getPiece().getPieceType() != PieceType.BLANK_PIECE) && (distance != distanceToCover)){
				return false;
			}
			//THIS CONDITION IF FOR JUST A MOVE
			else if((distance == distanceToCover) && ((testSquare.getPiece().getPieceType() == PieceType.BLANK_PIECE))){
				return true;
			}
			//THIS CONDITION IS FOR A MOVE WHICH INCLUDES CUTTING
			else if((distance == distanceToCover) && (testSquare.getPiece().getColor() != playerColor)){
				displayCutMessage(fromSquare, toSquare);
				isGameOver(toSquare);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		
		if(color == Color.BLACK)
			return "BR ";
		else 
			return "WR ";
	}
	
	
	
}
