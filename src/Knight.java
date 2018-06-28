
public class Knight extends Piece {

	
	
	public Knight(String color, Location location) {
		super(color, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean isPieceAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		if(color == "black") 
			return "BKn";
		else 
			return "WKn";
	}
	
	

}
