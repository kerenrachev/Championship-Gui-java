package Model;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Model {
    private ArrayList <Player> PlayersArray;
    private int numOfParticipants;
    private int currentNumOfParticipants;
    private ArrayList <Game> champGames;
    private String typeOfChamp;
    
       public  Model() {
    	champGames= new ArrayList <>();
		currentNumOfParticipants=0;
		PlayersArray= new ArrayList<Player>();
		numOfParticipants=0;
		Player p1= new Player(50,110);
		Player p2= new Player(50,170);
		Player p3= new Player(50,230);
		Player p4= new Player(50,290);
		Player p5= new Player(50,350);
		Player p6= new Player(50,410);
		Player p7= new Player(50,470);
		Player p8= new Player(50,530);
		PlayersArray.add(p1);
		PlayersArray.add(p2);
		PlayersArray.add(p3);
		PlayersArray.add(p4);
		PlayersArray.add(p5);
		PlayersArray.add(p6);
		PlayersArray.add(p7);
		PlayersArray.add(p8);
		this.typeOfChamp="tennis";
	}
	
	public void show(Group root) {
		root.getChildren().clear();
		for(int i=0;i<PlayersArray.size();i++) {
			PlayersArray.get(i).show(root);
		}
	}
    public void setCurrentNum() {
    	currentNumOfParticipants++;
    }
	public int getCurrentNumOfParticipants() {
		return currentNumOfParticipants;
	}
	public void startSoccer() {
		typeOfChamp="soccer";
	}
	public void startTennis() {
		typeOfChamp="tennis";
	}
	public void startBasketBall() {
		typeOfChamp="basketball";
	}
	public ArrayList <Game> getGamesArray() {
		return champGames;
	}

	public String getTypeOfGame() {
		return typeOfChamp;
	}
    public ArrayList <Player> getPlayersArray(){
    	return PlayersArray;
    }
    public Game initializeAllGames(Player p1, Player p2, Player winner,Button button, Game game) {
    	if(returnNumOfTextFieldsByGameType()==2) {
    		 game = new SoccerGame(p1,p2,button,winner);
        		champGames.add(game);
    	}
    	if(returnNumOfTextFieldsByGameType()==4) {
        		game = new BasketballGame(p1,p2,button,winner);
        		champGames.add(game);
    	}
    	if(returnNumOfTextFieldsByGameType()==5) {
        		game = new TennisGame(p1,p2,button,winner);
        		champGames.add(game);
    	}
    	return game;
    }
	public int returnNumOfTextFieldsByGameType() {
		if(typeOfChamp.equalsIgnoreCase("soccer")) {
			return 2;
		}
		if(typeOfChamp.equalsIgnoreCase("soccerThirdHalf")) {
			return 3;
		}
		if(typeOfChamp.equalsIgnoreCase("soccerTie")) {
			return 3;
		}
		if(typeOfChamp.equalsIgnoreCase("basketball")) {
			return 4;
		}
		else {
			return 5;
		}
	}
	public void setGameType(String string) {
		this.typeOfChamp=string;
		
	}
}
