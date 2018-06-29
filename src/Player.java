import java.util.Scanner;

public class Player {
	
	private String name;
	private int ponitsScored;
	private Color color;
	
	Scanner sc = new Scanner(System.in);

	public Player(String name, Color color) {
		this.name = name;
		this.ponitsScored = 0;
		this.color = color;
	}
	
	public void updatePlayerPoints(int newPoint) {
		this.ponitsScored += newPoint;
	}
	
	
	private int convertCharToNum(char charIn){
		   //HERE WE RETURN -1 IF IT IS NOT A VALID INPUT(i.e input outside the box)
			int number = -1;
			
			for(int i = 0; i < ChessBoard.BOARD_LETTERS.length; i++){
				
				if(ChessBoard.BOARD_LETTERS[i] == charIn){
					number = i;
				}
			}
			return number;
		}
	
	private int convertCharNumtoNum(char charIn){ 
		//HERE WE RETURN -1 IF IT IS NOT A VALID INPUT(i.e input outside the box)
		int number = -1;
		int convertedNum = Character.getNumericValue(charIn);
		
		for(int i: ChessBoard.BOARD_NUMS){
			if(i == convertedNum){
				number = convertedNum;   
			}
		}
		return number;
	}
	
	
	public int[][] getPlayerMove() {
		
		int[][] move = new int[2][2];
		
		for(int runNum = 1; runNum <= 2; runNum++){
			
			while(true){
				
				if(runNum == 1){ 
					System.out.print(this.name + ", input the location of the piece which you want to move.\n>> ");
				}

				else{ 
					System.out.print(name + ", input the location to which you want to move the piece to.\n>> ");
				}
				
				String moveIn = sc.nextLine();
			
				if(!moveIn.isEmpty() && moveIn.length() <= 2 && !(moveIn.contains(" ") || moveIn.contains("\t"))){
				
					//making sure first char is a char and making sure the second is a digit
					if(!Character.isDigit(moveIn.charAt(0)) && Character.isDigit(moveIn.charAt(1))){	
						
						int x, y;
			
						if((x = convertCharToNum(Character.toUpperCase(moveIn.charAt(0)))) != -1){
							
							if((y = convertCharNumtoNum(moveIn.charAt(1))) != -1){
								y = 8 - y;
								int tempArray[] = {x, y};
								if(runNum == 1){
									if(ChessBoard.getSquare(y,x).getPiece().getPieceType() == Piece.PieceType.BLANK_PIECE || ChessBoard.getSquare(y,x).getPiece().getColor() != color){
										tempArray[0] = -1;																
										tempArray[1] = -1;
										int[][] invalidArray = {tempArray, tempArray};
										return invalidArray;
									}
								}
								
								move[runNum - 1] = tempArray;
								break;
							}
						}
					}
				}
				System.out.println("Invalid location. Try again."); //can only get here if the other possibilities fail
			}		
		}
		return move;
	}
}
