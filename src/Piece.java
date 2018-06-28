
public abstract class Piece {
	
	String color;
	Location location;
	
	
	
	public Piece(String color, Location location) {
		
		this.color = color;
		this.location = location;
		
	}

	abstract boolean isValidMove();
	
	abstract boolean isPieceAvailable();
	
	
	
	
}
