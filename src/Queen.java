

public class Queen extends Piece {

	public Queen(Color color, Location location, PieceType type) {
		super(color, location, type);
	}
	
	public enum Direction {
		RIGHT_STRAIGHT("straight"), LEFT_STRAIGHT("straight"), BOTTOM_STRAIGHT("straight"), TOP_STRAIGHT("straight"),
		TOP_RIGHT_DIAGONAL("diagonal"), TOP_LEFT_DIAGONAL("diagonal"), BOTTOM_RIGHT_DIAGONAL("diagonal"), BOTTOM_LEFT_DIAGONAL("diagonal");
		
		private String type;
		Direction(String type) {
			this.type = type;
		}
		
		public String getType() {
			return this.type;
		}
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
		String type;
		
		if(moveToY == moveFromY){
			if(moveToX > moveFromX){
				direction = Direction.RIGHT_STRAIGHT;
				type = direction.getType();
			}
			else{
				direction = Direction.LEFT_STRAIGHT;
				type = direction.getType();
			}
		}
		
		else if(moveToX == moveFromX){
			if(moveToY > moveFromY){
				direction = Direction.BOTTOM_STRAIGHT;
				type = direction.getType();
			}
			else{
				direction = Direction.TOP_STRAIGHT;
				type = direction.getType();
			}
		}
		else if(moveToX > moveFromX){
			if(moveToY < moveFromY){
				direction = Direction.TOP_RIGHT_DIAGONAL;
				type = direction.getType();
			}
			else{
				direction = Direction.BOTTOM_RIGHT_DIAGONAL;
				type = direction.getType();
			}
		}
		else if(moveToX < moveFromX){
			if(moveToY < moveFromY){
				direction = Direction.TOP_LEFT_DIAGONAL;
				type = direction.getType();
			}
			else{
				direction = Direction.BOTTOM_LEFT_DIAGONAL;
				type = direction.getType();
			}
		}
		else{
			return false;
		}
		
		Square testSquare = null;
		
		if(type == "diagonal"){
			int moveDistance = Math.abs(moveToX - moveFromX);
		
			for(int diagMoveAway = 1; diagMoveAway <= moveDistance; diagMoveAway++){
			
				if(direction == Direction.TOP_RIGHT_DIAGONAL){
					testSquare = ChessBoard.getSquare(moveFromY - diagMoveAway, moveFromX + diagMoveAway);
				}
				else if(direction == Direction.BOTTOM_RIGHT_DIAGONAL){
					testSquare = ChessBoard.getSquare(moveFromY + diagMoveAway, moveFromX + diagMoveAway);
				}
				else if(direction == Direction.TOP_LEFT_DIAGONAL){
					testSquare = ChessBoard.getSquare(moveFromY - diagMoveAway, moveFromX - diagMoveAway);
				}
				else if(direction == Direction.BOTTOM_LEFT_DIAGONAL){ 
					testSquare = ChessBoard.getSquare(moveFromY + diagMoveAway, moveFromX - diagMoveAway);
				}
			
				if((testSquare.getPiece().getPieceType() != PieceType.BLANK_PIECE) && (diagMoveAway != moveDistance)){
					return false;
				}
				else if((diagMoveAway == moveDistance) && (testSquare.getPiece().getPieceType() == PieceType.BLANK_PIECE)){
					return true;
				}
				else if((diagMoveAway == moveDistance) && (testSquare.getPiece().getColor() != playerColor)) {
					displayCutMessage(fromSquare, toSquare);
					isGameOver(toSquare);
					return true;
				}
			}
		}
		
		else { 
			if((direction == Direction.RIGHT_STRAIGHT) || (direction == Direction.LEFT_STRAIGHT)){
				int displaceMax = Math.abs(moveToX - moveFromX); //displacement max depending on what the move to values are
		
				for(int displace = 1; displace <= displaceMax; displace++){ //looping through squares on the rooks path
					if(direction == Direction.RIGHT_STRAIGHT){
						testSquare = ChessBoard.getSquare(moveFromY, moveFromX + displace);
					
						if((testSquare.getPiece().getPieceType() != PieceType.BLANK_PIECE) && (displace != displaceMax)){
						return false;
						}
						else if((displace == displaceMax) && (testSquare.getPiece().getPieceType() == PieceType.BLANK_PIECE)){
							return true;
						}
						else if((displace == displaceMax) && (testSquare.getPiece().getColor() != playerColor)) {
							displayCutMessage(fromSquare, toSquare);
							isGameOver(toSquare);
							return true;
						}
					}
					else if(direction == Direction.LEFT_STRAIGHT){
						testSquare = ChessBoard.getSquare(moveFromY, moveFromX - displace);
					
						if((testSquare.getPiece().getPieceType() != PieceType.BLANK_PIECE) && (displace != displaceMax)){
							return false;
						}
						else if((displace == displaceMax) && ((testSquare.getPiece().getPieceType() == PieceType.BLANK_PIECE))){
							return true;
						}
						else if((displace == displaceMax) && (testSquare.getPiece().getColor() != playerColor)) {
							displayCutMessage(fromSquare, toSquare);
							isGameOver(toSquare);
							return true;
						}
					}
				}
			}
			else{ // direction : top or bottom
				int displaceMax = Math.abs(moveToY - moveFromY); //displacement max depending on what the move to values are
				
				for(int displace = 1; displace <= displaceMax; displace++){ //looping through squares on the rooks path	
				
					if(direction == Direction.TOP_STRAIGHT){
						testSquare = ChessBoard.getSquare(moveFromY - displace, moveFromX);
					
						if((testSquare.getPiece().getPieceType() != PieceType.BLANK_PIECE) && (displace != displaceMax)){
							return false;
						}
						else if((displace == displaceMax) && ((testSquare.getPiece().getPieceType() == PieceType.BLANK_PIECE))){
							return true;
						}
						else if((displace == displaceMax) && (testSquare.getPiece().getColor() != playerColor)) {
							displayCutMessage(fromSquare, toSquare);
							isGameOver(toSquare);
							return true;
						}
					}
					else if(direction == Direction.BOTTOM_STRAIGHT){
						testSquare = ChessBoard.getSquare(moveFromY + displace, moveFromX);
					
						if((testSquare.getPiece().getPieceType() != PieceType.BLANK_PIECE) && (displace != displaceMax)){
							return false;
						}
						else if((displace == displaceMax) && ((testSquare.getPiece().getPieceType() == PieceType.BLANK_PIECE))){
							return true;
						}
						else if((displace == displaceMax) && (testSquare.getPiece().getColor() != playerColor)) {
							displayCutMessage(fromSquare, toSquare);
							isGameOver(toSquare);
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	@Override
	public String toString() {
		if(color == Color.BLACK)
			return "BQ ";
		else
			return "WQ ";
	}
	
	

}
