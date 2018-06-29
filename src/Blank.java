
public class Blank extends Piece{

	public Blank(Color color, Location location, PieceType type) {
		super(color, location, type);
		
	}

	@Override
	public String toString() {
		return "   ";
	}

	@Override
	boolean isValidMove(int[] source, int[] destination, Color color) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
