
public class Pawn extends Piece {

	
	
	public Pawn(String color, Location location) {
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
			return "BP ";
		else 
			return "WP ";
	}
	
	

}
