import java.util.Scanner;


public class ChessGame {
	
	private ChessBoard board;
	private Player blackPlayer;
	private Player whitePlayer;
	
	static Scanner sc = new Scanner(System.in);

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
	
	private static Player.PlayerColor getColor(String name) {
		System.out.print("Hey " + name + " please select a color.\n>> ");
		System.out.println("1) BLACK 2) WHITE\n");
	
		
		while(true) {
			int option = sc.nextInt();
			
			switch(option) {
			
			case 1:
				return Player.PlayerColor.BLACK;
			
			case 2:
				return Player.PlayerColor.WHITE;
			
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
		Player.PlayerColor player1Color, player2Color;
		
		player1Name = getName(1, null);
		player2Name= getName(2, player1Name);
		
		player1Color = getColor(player1Name);
		//Automatically assigning the color for player 2
		player2Color = (player1Color == Player.PlayerColor.BLACK) ? Player.PlayerColor.WHITE : Player.PlayerColor.BLACK;
		
		Player blackPlayer, whitePlayer;
		
		if(player1Color == Player.PlayerColor.BLACK) {
            blackPlayer = new Player(player1Name, player1Color);
			whitePlayer = new Player(player2Name, player2Color);
		}
		
		else {
			whitePlayer = new Player(player1Name, player1Color);
			blackPlayer = new Player(player2Name, player2Color);
		}
		
		//HERE WE ARE STARTING A NEW CHESS GAME
		ChessGame newChessGame = new ChessGame(blackPlayer, whitePlayer);
		
		
		newChessGame.draw(newChessGame);
	
		
	}

}
