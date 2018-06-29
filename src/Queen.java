

public class Queen extends Piece {

	
	
	public Queen(Color color, Location location, PieceType type) {
		super(color, location, type);
	}
	
	public enum Direction {
		RIGHT_STRAIGHT, LEFT_STRAIGHT, BOTTOM_STRAIGHT, TOP_STRAIGHT,
		TOP_RIGHT_DIAGONAL, TOP_LEFT_DIAGONAL, BOTTOM_RIGHT_DIAGONAL, BOTTOM_LEFT_DIAGONAL;
		
	}
	@Override
	boolean isValidMove(int[] source, int[] destination, Color color) {
		
		int moveFromX = source[0];
		int moveFromY = source[1];
		int moveToX = destination[0];
		int moveToY = destination[1];
		
		Square fromSquare = ChessBoard.getSquare(moveFromY, moveFromX);
		Square toSquare = ChessBoard.getSquare(moveToY, moveToX);
		
		Direction direction;
		
		
		if(moveToY == moveFromY){
			if(moveToX > moveFromX){
				direction = Direction.RIGHT_STRAIGHT;
			}
			else{
				direction = Direction.LEFT_STRAIGHT;
			}
		}
		
		else if(moveToX == moveFromX){
			if(moveToY > moveFromY){
				direction = Direction.BOTTOM_STRAIGHT;
			}
			else{
				direction = Direction.TOP_STRAIGHT;
			}
		}
		else if(moveToX > moveFromX){
			if(moveToY < moveFromY){
				direction = Direction.TOP_RIGHT_DIAGONAL;
			}
			else{
				direction = Direction.BOTTOM_RIGHT_DIAGONAL;
			}
		}
		else if(moveToX < moveFromX){
			if(moveToY < moveFromY){
				direction = Direction.TOP_LEFT_DIAGONAL;
			}
			else{
				direction = Direction.BOTTOM_LEFT_DIAGONAL;
			}
		}
		else{
			return false;
		}
		
		Square testSquare;
		
		/*if(type == "diagonal"){
			int moveDistance = Math.abs(moveToX - moveFromX);
		
			for(int diagMoveAway = 1; diagMoveAway <= moveDistance; diagMoveAway++){
			
				if(direction == "topRite"){
					testSquare = Board.board[moveFromY - diagMoveAway][moveFromX + diagMoveAway];
				}
				else if(direction == "botRite"){
					testSquare = Board.board[moveFromY + diagMoveAway][moveFromX + diagMoveAway];
				}
				else if(direction == "topLeft"){
					testSquare = Board.board[moveFromY - diagMoveAway][moveFromX - diagMoveAway];
				}
				else{ //botLeft
					testSquare = Board.board[moveFromY + diagMoveAway][moveFromX - diagMoveAway];
				}
			
				if((testSquare.getType() != "blank") && (diagMoveAway != moveDistance)){
					return false;
				}
				else if((diagMoveAway == moveDistance) && ((testSquare.getColor() != plyColor) || (testSquare.getType() == "blank"))){
					return true;
				}
			}
		}
		else{ //straight
			if((direction == "rite") || (direction == "left")){
				int displaceMax = Math.abs(moveToX - moveFromX); //displacement max depending on what the move to values are
		
				for(int displace = 1; displace <= displaceMax; displace++){ //looping through squares on the rooks path
					if(direction == "rite"){
						testSquare = Board.board[moveFromY][moveFromX + displace];
					
						if((testSquare.getType() != "blank") && (displace != displaceMax)){
						return false;
						}
						else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != plyColor))){
							return true;
						}
					}
					else{
						testSquare = Board.board[moveFromY][moveFromX - displace];
					
						if((testSquare.getType() != "blank") && (displace != displaceMax)){
							return false;
						}
						else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != plyColor))){
							return true;
						}
					}
				}
			}
			else{ // direction : top or bot
				int displaceMax = Math.abs(moveToY - moveFromY); //displacement max depending on what the move to values are
				
				for(int displace = 1; displace <= displaceMax; displace++){ //looping through squares on the rooks path	
				
					if(direction == "top"){
						testSquare = Board.board[moveFromY - displace][moveFromX];
					
						if((testSquare.getType() != "blank") && (displace != displaceMax)){
							return false;
						}
						else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != plyColor))){
							return true;
						}
					}
					else{
						testSquare = Board.board[moveFromY + displace][moveFromX];
					
						if((testSquare.getType() != "blank") && (displace != displaceMax)){
							return false;
						}
						else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != plyColor))){
							return true;
						}
					}
				}
			}
		}*/

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
