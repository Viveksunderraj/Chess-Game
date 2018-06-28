
public class Queen extends Piece {

	
	
	public Queen(String color, Location location) {
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
			return "BQ ";
		else
			return "WQ ";
	}
	
	

}
