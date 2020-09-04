package Model;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BasketballGame extends Game{
	private ArrayList <Player> playersArray;
	public BasketballGame(Player player1, Player player2, Button button ,Player winnerPlayer) {
		super(player1, player2,4, button, winnerPlayer);
	}
}
