
public class ChessBoard {
	
	private static Square[][] squares = new Square[8][8];
	
	static final char SIDE_LETTERS[] = {'A','B','C','D','E','F','G','H'};
	static final int SIDE_NUMS[] = {1,2,3,4,5,6,7,8};

	public ChessBoard() {
		
		setupBoard();
	}
	
	private static void setupBoard() {
		
		final String BLACK = "black";
		final String WHITE = "white";
		//HERE WE FILL THE BOARD WILL BLACK PIECES
		squares[0][0] = new Square(new Rook(BLACK, new Location(0, 0)));
		squares[0][1] = new Square(new Knight(BLACK, new Location(0, 1)));
		squares[0][2] = new Square(new Bishop(BLACK, new Location(0, 2)));
		squares[0][3] = new Square(new Queen(BLACK, new Location(0, 3)));
		squares[0][4] = new Square(new King(BLACK, new Location(0, 4)));
		squares[0][5] = new Square(new Bishop(BLACK, new Location(0, 5)));
		squares[0][6] = new Square(new Knight(BLACK, new Location(0, 6)));
		squares[0][7] = new Square(new Rook(BLACK, new Location(0, 7)));
		
		//HERE WE FILL THE BOARD WITH BLACK PAWNS
		for(int i = 0; i < 8; i++){
			squares[1][i] = new Square(new Pawn(BLACK, new Location(1, i)));
		}
		
		//HERE WE ARE CREATNG BLANK SPACES IN THE MIDDLE
		for(int i = 2; i < 6; i++){ 
			for(int j = 0; j < 8; j++){
				squares[i][j] = null;
			}
		}
		
		
		//HERE WE FILL THE BOARD WITH WHITE PAWNS
		for(int i = 0; i < 8; i++){
			squares[6][i] = new Square(new Pawn(WHITE, new Location(6, i)));;
		}

		//HERE WE FILL THE BOARD WILL WHITE PIECES
		squares[7][0] = new Square(new Rook(WHITE, new Location(7, 0)));
		squares[7][1] = new Square(new Knight(WHITE, new Location(7, 1)));
		squares[7][2] = new Square(new Bishop(WHITE, new Location(7, 2)));
		squares[7][3] = new Square(new Queen(WHITE, new Location(7, 3)));
		squares[7][4] = new Square(new King(WHITE, new Location(7, 4)));
		squares[7][5] = new Square(new Bishop(WHITE, new Location(7, 5)));
		squares[7][6] = new Square(new Knight(WHITE, new Location(7, 6)));
		squares[7][7] = new Square(new Rook(WHITE, new Location(7, 7)));
		
	}
	
	public void drawBoard() {
		
        System.out.print("\n   ");
		
		//HERE WE PRINT THE LETTERS ACCROSS THE TOP
        for(char i: SIDE_LETTERS){ 
			System.out.print("  " + i + "  ");
		}
		System.out.print("\n   ");
		
		for(int i = 0; i < 8; i++){
			System.out.print(" --- ");
		}
		
		System.out.print("\n");
		
		for(int i = 0; i < 8; i++){ //looping through the board and printing symbols
			System.out.print(" " + (8 - i) + " "); //print number on left side
			
			for(Square square: squares[i]){
				if(square != null)
					System.out.print("|" + square.getPiece().toString() + "|");
				else 
					System.out.print("|" + "   " + "|");
			}
			System.out.print(" " + (8 - i) + " "); //number on right side
			
			System.out.print("\n   ");//to get next line
			
			for(int j = 0; j < 8; j++){
				System.out.print(" --- ");
			}
			System.out.print("\n");
		}
		System.out.print("   ");
		
		//HERE WE PRINT THE LETTERS ACCROSS THE BOTTOM
		for(char i: SIDE_LETTERS){ 
			System.out.print("  " + i + "  ");
		}
		System.out.print("\n\n");
	}
}

