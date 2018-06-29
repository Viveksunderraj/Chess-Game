
public class Knight extends Piece {

	public Knight(Color color, Location location, PieceType type) {
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
		
		
		boolean canMove = false;
		
		for(int displaceX = -2; displaceX <= 2; displaceX++){
		
			if(displaceX != 0){
				if(moveToX == moveFromX + displaceX){
					//IF THE X DISPLACE WAS 1 THEN THE Y DISPLACE MUST BE 2
					if(Math.abs(displaceX) == 1){ 
						for(int displaceY = -2; displaceY <= 2; displaceY += 4){
							if(moveToY == moveFromY + displaceY){
								canMove = true;
							}
						}
					}
					else{
						for(int displaceY = -1; displaceY <= 1; displaceY += 2){
							if(moveToY == moveFromY + displaceY){
								canMove = true;
							}
						}
					}
				}
			}
		}
		
		//IF THE KNIGHT CAN MOVE THEN WE RETURN TRUE
		if(canMove){ 
			
			if((toSquare.getPiece().getPieceType() == PieceType.BLANK_PIECE)){
				return true;
			}
			else if(toSquare.getPiece().getColor() != playerColor) {
				displayCutMessage(fromSquare, toSquare);
				return true;
			}
		}
		return false;
	}

	
	@Override
	public String toString() {
		if(color == Color.BLACK) 
			return "BKn";
		else 
			return "WKn";
	}
	
	

}
