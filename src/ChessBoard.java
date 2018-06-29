
public class ChessBoard {
	
	private static Square[][] squares = new Square[8][8];
	
	static final char BOARD_LETTERS[] = {'A','B','C','D','E','F','G','H'};
	static final int BOARD_NUMS[] = {1,2,3,4,5,6,7,8};

	public ChessBoard() {
		
		setupBoard();
	}
	
	
	public static Square getSquare(int x, int y) {
		return squares[x][y];
	}
	
	private static void setupBoard() {
		
		//HERE WE FILL THE BOARD WILL BLACK PIECES
		squares[0][0] = new Square(new Rook(Color.BLACK, new Location(0, 0), Piece.PieceType.BLACK_ROOK));
		squares[0][1] = new Square(new Knight(Color.BLACK, new Location(0, 1), Piece.PieceType.BLACK_KNIGHT));
		squares[0][2] = new Square(new Bishop(Color.BLACK, new Location(0, 2), Piece.PieceType.BLACK_BISHOP));
		squares[0][3] = new Square(new Queen(Color.BLACK, new Location(0, 3), Piece.PieceType.BLACK_QUEEN));
		squares[0][4] = new Square(new King(Color.BLACK, new Location(0, 4), Piece.PieceType.BLACK_KING));
		squares[0][5] = new Square(new Bishop(Color.BLACK, new Location(0, 5),Piece.PieceType.BLACK_BISHOP));
		squares[0][6] = new Square(new Knight(Color.BLACK, new Location(0, 6), Piece.PieceType.BLACK_KNIGHT));
		squares[0][7] = new Square(new Rook(Color.BLACK, new Location(0, 7), Piece.PieceType.BLACK_ROOK));
		
		//HERE WE FILL THE BOARD WITH BLACK PAWNS
		for(int i = 0; i < 8; i++){
			squares[1][i] = new Square(new Pawn(Color.BLACK, new Location(1, i), Piece.PieceType.BLACK_PAWN));
		}
		
		//HERE WE ARE CREATNG BLANK SPACES IN THE MIDDLE
		for(int i = 2; i < 6; i++){ 
			for(int j = 0; j < 8; j++){
				squares[i][j] = new Square(new Blank(Color.NIL, new Location(i, j), Piece.PieceType.BLANK_PIECE));
			}
		}
		
		
		//HERE WE FILL THE BOARD WITH WHITE PAWNS
		for(int i = 0; i < 8; i++){
			squares[6][i] = new Square(new Pawn(Color.WHITE, new Location(6, i), Piece.PieceType.WHITE_PAWN));;
		}

		//HERE WE FILL THE BOARD WILL WHITE PIECES
		squares[7][0] = new Square(new Rook(Color.WHITE, new Location(7, 0), Piece.PieceType.WHITE_ROOK));
		squares[7][1] = new Square(new Knight(Color.WHITE, new Location(7, 1), Piece.PieceType.WHITE_KNIGHT));
		squares[7][2] = new Square(new Bishop(Color.WHITE, new Location(7, 2), Piece.PieceType.WHITE_BISHOP));
		squares[7][3] = new Square(new Queen(Color.WHITE, new Location(7, 3), Piece.PieceType.WHITE_QUEEN));
		squares[7][4] = new Square(new King(Color.WHITE, new Location(7, 4), Piece.PieceType.WHITE_KING));
		squares[7][5] = new Square(new Bishop(Color.WHITE, new Location(7, 5), Piece.PieceType.WHITE_BISHOP));
		squares[7][6] = new Square(new Knight(Color.WHITE, new Location(7, 6), Piece.PieceType.WHITE_KNIGHT));
		squares[7][7] = new Square(new Rook(Color.WHITE, new Location(7, 7), Piece.PieceType.WHITE_ROOK));
		
	}
	
	public static void updateMoveInBoard(int[] source, int[] destination) {
		Square sourceSquare = squares[source[1]][source[0]];
		sourceSquare.getPiece().updateLocation(new Location(destination[1],destination[0]));
		
		squares[destination[1]][destination[0]] = squares[source[1]][source[0]];
		squares[source[1]][source[0]] = new Square(new Blank(Color.NIL, new Location(source[1], source[0]), Piece.PieceType.BLANK_PIECE));
		
	}
	
	public void drawBoard() {
		
        System.out.print("\n   ");
		
		//HERE WE PRINT THE LETTERS ACCROSS THE TOP
        for(char i: BOARD_LETTERS){ 
			System.out.print("  " + i + "  ");
		}
		System.out.print("\n   ");
		
		for(int i = 0; i < 8; i++){
			System.out.print(" --- ");
		}
		
		System.out.print("\n");
		
		for(int i = 0; i < 8; i++){ 
			System.out.print(" " + (8 - i) + " ");
			
			for(Square square: squares[i]){
					System.out.print("|" + square.getPiece().toString() + "|");
			}
			System.out.print(" " + (8 - i) + " ");
			
			System.out.print("\n   ");
			
			for(int j = 0; j < 8; j++){
				System.out.print(" --- ");
			}
			System.out.print("\n");
		}
		System.out.print("   ");
		
		//HERE WE PRINT THE LETTERS ACCROSS THE BOTTOM
		for(char i: BOARD_LETTERS){ 
			System.out.print("  " + i + "  ");
		}
		System.out.print("\n\n");
	}
}

