
public class Pawn extends Piece {

	private boolean isFirstMove = true;
	
	public Pawn(Color color, Location location, PieceType type) {
		super(color, location, type);
	}

	@Override
	boolean isValidMove(int[] source, int[] destination, Color playerColor) {
		int moveFromX = source[0];
		int moveFromY = source[1];
		int moveToX = destination[0];
		int moveToY = destination[1];
		
		//System.out.println("moveFromX " + moveFromX + " moveFromY " + moveFromY + " moveToX " + moveToX + " moveToY " + moveToY);
		
		int moveForwardTwo;
		int moveForwardOne;
		boolean isDestinationEmpty;
		
		Square fromSquare = ChessBoard.getSquare(moveFromY, moveFromX);
		Square toSquare = ChessBoard.getSquare(moveToY, moveToX);
		if(toSquare.getPiece().getPieceType() == PieceType.BLANK_PIECE) {
			isDestinationEmpty = true;
		}
		else {
			isDestinationEmpty = false;
		}
		
		//AS A PAWN CAN ONLY MOVE FORWARS SETTING THESE TWO CONSTANTS FOR EACH COLOR
		if(playerColor == Color.WHITE){
			moveForwardTwo = -2;
			moveForwardOne = -1;
		}
		else{ 
			moveForwardTwo = 2;
			moveForwardOne = 1;
		}
			
		if(moveToY == moveFromY + moveForwardOne){
			
			//MOVE TO CUT A PIECE DIAGONALLY
			if((moveToX == moveFromX - 1) || (moveToX == moveFromX + 1)){
				if((!isDestinationEmpty) && (toSquare.getPiece().color != playerColor)){
					displayCutMessage(fromSquare, toSquare);
					isGameOver(toSquare);
					isFirstMove = false;
					return true; 
				}
			}	
			//FOR A STRAIGHT MOVE BY ONE SQUARE
			else if((moveToX == moveFromX) && (isDestinationEmpty)){ 
				//System.out.println("IN ONE MOVE");
				isFirstMove = false;
				return true;
			}
		}
		//FOR A STRAIGHT MOVE BY TWO SQUARES
		else if((moveToY == moveFromY + moveForwardTwo) && (moveToX == moveFromX) && (isDestinationEmpty)){ 
			if(isFirstMove){
				isFirstMove = false;
				return true;
			}
		}
		
		return false; 
	}	


	@Override
	public String toString() {
		if(color == Color.BLACK)
			return "BP ";
		else 
			return "WP ";
	}

}
