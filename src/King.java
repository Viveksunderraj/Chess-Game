
public class King extends Piece {

	
	
	public King(String color, Location location) {
		super(color, location);
		
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
		if (color == "black")
			return "BKi";
		else 
			return "WKi";
	}
	
	

}
