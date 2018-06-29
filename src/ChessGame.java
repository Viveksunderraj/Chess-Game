import java.util.Scanner;


public class ChessGame {
	
	private ChessBoard board;
	private Player blackPlayer;
	private Player whitePlayer;
	
	static Scanner sc = new Scanner(System.in);
	static boolean gameNotOver = true;

	public ChessGame(Player blackPlayer, Player whitePlayer) {

		this.board = new ChessBoard();
		this.blackPlayer = blackPlayer;
		this.whitePlayer = whitePlayer;
	}

	
	private static String getName(int playerNum, String prevName){ 
		String name;
		
		while(true){
			System.out.print("Player " + playerNum + " please enter your name.\n>> ");
			name = sc.nextLine();
			
			if(!name.equals(prevName)) 
				break; 
			else
				System.out.println("Invalid name. Try again.");
		}
		return name;
	}
	
/*	public static Player getBlackPlayer() {
		return blackPlayer;
	}
	
	public static Player getWhitePlayer() {
		return this.whitePlayer;
	}*/
	
	private static Color getColor(String name) {
		System.out.print("Hey " + name + " please select a color.\n>> ");
		System.out.println("1) BLACK 2) WHITE\n");
	
		
		while(true) {
			int option = sc.nextInt();
			
			switch(option) {
			
			case 1:
				return Color.BLACK;
			
			case 2:
				return Color.WHITE;
			
			default:
				System.out.println("Invalid Option. Try again.");
			}
	    }
	}
	
	public void draw(ChessGame chessGame) {
		chessGame.board.drawBoard();
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("=============> WELCOME TO THE CHESS GAME <=============");
		
		String player1Name, player2Name;
		Color player1Color, player2Color;
		
		boolean isWhitePlayerTurn = true;
		
		player1Name = getName(1, null);
		player2Name= getName(2, player1Name);
		
		player1Color = getColor(player1Name);
		//Automatically assigning the color for player 2
		player2Color = (player1Color == Color.BLACK) ? Color.WHITE : Color.BLACK;
		
		Player blackPlayer, whitePlayer;
		
		if(player1Color == Color.BLACK) {
            blackPlayer = new Player(player1Name, player1Color);
			whitePlayer = new Player(player2Name, player2Color);
		}
		
		else {
			whitePlayer = new Player(player1Name, player1Color);
			blackPlayer = new Player(player2Name, player2Color);
		}
		
		//HERE WE ARE STARTING A NEW CHESS GAME
		ChessGame newChessGame = new ChessGame(blackPlayer, whitePlayer);
		
		 while(gameNotOver)
		 {
			
		    newChessGame.draw(newChessGame);
			int move[][] = new int[2][2];
			
			if(isWhitePlayerTurn) {
				move = newChessGame.whitePlayer.getPlayerMove();
			}
			else {
				move = newChessGame.blackPlayer.getPlayerMove();
			}
			
			if(move[0][0] == -1){
				System.out.println("Invalid location. Try again.");
				continue;
			}
			
			
			int[] source = move[0];
			int[] destination = move[1];
			Square moveFromSquare = ChessBoard.getSquare(source[1], source[0]);
		
			boolean isValidMove;
			if(isWhitePlayerTurn){
				isValidMove = moveFromSquare.getPiece().isValidMove(source, destination, Color.WHITE);
			}
			else{
				isValidMove = moveFromSquare.getPiece().isValidMove(source, destination, Color.BLACK);
			}
			
			
			if(isValidMove) {
				ChessBoard.updateMoveInBoard(source, destination);
			}
			else {
				System.out.println("Invalid MOVE. Try again.");
				continue;
			}
			
			
			//HERE WE ARE FLIPPING THE STATE, SO THAT WE CAN SWITCH THE PLAYERS TURN
			isWhitePlayerTurn = !isWhitePlayerTurn;
		 }
	
		
	}

}
