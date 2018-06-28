
public class Player {
	
	private String name;
	private int ponitsScored;
	private PlayerColor color;
	
	public enum PlayerColor {
		BLACK, WHITE;
	}

	public Player(String name, PlayerColor color) {
		this.name = name;
		this.ponitsScored = 0;
		this.color = color;
	}
	
}
