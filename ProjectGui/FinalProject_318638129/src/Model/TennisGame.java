package Model;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TennisGame extends Game{
	
	public TennisGame(Player player1, Player player2, Button button,Player winnerPlayer) {
		super(player1,player2,5, button,winnerPlayer);
	}

}
