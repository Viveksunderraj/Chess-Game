
public abstract class Piece {
	
	protected Color color;
	protected Location location;
	protected PieceType type;
	
	public Piece(Color color, Location location, PieceType type) {
		
		this.color = color;
		this.location = location;
		this.type = type;
		
	}
	
	abstract boolean isValidMove(int[] source, int[] destination, Color color);
	
	public enum PieceType {
		BLACK_ROOK, BLACK_KNIGHT, BLACK_BISHOP, BLACK_QUEEN, BLACK_KING, BLACK_PAWN,
		WHITE_ROOK, WHITE_KNIGHT, WHITE_BISHOP, WHITE_QUEEN, WHITE_KING, WHITE_PAWN,
		BLANK_PIECE;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public PieceType getPieceType() {
		return this.type;
	}
	
	public void updateLocation(Location newLocation) {
		this.location = newLocation;
	}
	
	public void displayCutMessage(Square fromSquare, Square toSquare) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(toSquare.getPiece().getPieceType() + " has been cut by " + fromSquare.getPiece().getPieceType());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	public void isGameOver(Square toSquare) {
		if(toSquare.getPiece().getPieceType() == PieceType.BLACK_KING) {
			System.out.println("WHITE PLAYER HAS WON THE GAME");
			ChessGame.gameNotOver = false;
		}
		else if(toSquare.getPiece().getPieceType() == PieceType.WHITE_KING){
			System.out.println("BLACK PLAYER HAS WON THE GAME");
			ChessGame.gameNotOver = false;
		}
	}
	
}
