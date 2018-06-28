
public class Bishop extends Piece {
	

	public Bishop(String color, Location location) {
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
		if(color == "black")
			return "BB ";
		else 
			return "WB ";
	}
	
	

}
