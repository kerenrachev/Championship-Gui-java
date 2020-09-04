package Model;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Game {
	private Player  player1;
	private Player  player2;
	private Player  winnerPlayer;
	private Button  playButton;
	private int     numOfGames;
	private Boolean hadAnotherHalf;
	
	public Game(Player player1, Player player2, int numOfGames, Button button, Player winnerPlayer) {
		hadAnotherHalf=false;
		this.player1=player1;
		this.player2= player2;
		this.winnerPlayer= winnerPlayer;
		this.numOfGames=numOfGames;
		this.playButton=button;
	}
	public Game() {
		this (null,null,0,null,null);
	}
	public int getNumOfGames() {
		return numOfGames;
	}

	public void checkResults(ArrayList<TextField> textFieldArray) {

		int sumPlayer1=0;
		int sumPlayer2=0;
		if(numOfGames==5) {
			for(int i=0;i<numOfGames*2;i++) { 
				if(Integer.parseInt(textFieldArray.get(i).getText().toString())>Integer.parseInt(textFieldArray.get(i+1).getText().toString())) {
					sumPlayer1++;
				}
				else sumPlayer2++;
				i++;
			}
		}
		else {
			if(hadAnotherHalf) {
				if(Integer.parseInt(textFieldArray.get(4).getText().toString())>Integer.parseInt(textFieldArray.get(5).getText().toString())) {
					this.winnerPlayer.getLabel().setText(player1.getLabel().getText());
				}
				else this.winnerPlayer.getLabel().setText(player2.getLabel().getText());
			}
			for(int i=0;i<numOfGames*2;i++) { 
				sumPlayer1+=Integer.parseInt(textFieldArray.get(i).getText().toString());
				sumPlayer2+=Integer.parseInt(textFieldArray.get(i+1).getText().toString());
				i++;
			}
		}
		if(sumPlayer1>sumPlayer2) {
			this.winnerPlayer.getLabel().setText(player1.getLabel().getText());
		}
		else if(sumPlayer2>sumPlayer1) {
			this.winnerPlayer.getLabel().setText(player2.getLabel().getText());
		}
	}
	public boolean checkForTie(ArrayList<TextField> textFieldArray) {
		if(hadAnotherHalf) {
			if(Integer.parseInt(textFieldArray.get(4).getText().toString())==Integer.parseInt(textFieldArray.get(5).getText().toString())) {
				return true;
			}
			else return false;
		}
		int sumPlayer1=0;
		int sumPlayer2=0;
		for(int i=0;i<numOfGames*2;i++) { 
			sumPlayer1+=Integer.parseInt(textFieldArray.get(i).getText().toString());
			sumPlayer2+=Integer.parseInt(textFieldArray.get(i+1).getText().toString());
			i++;
		}
		 if (sumPlayer1==sumPlayer2){
				return true;
		}
		 else
			 return false;
	}
	public void setHadANotherHalf(Boolean b) {
		this.hadAnotherHalf=b;
	}
	public Boolean getHadAnotherHalf() {
		return hadAnotherHalf;
	}
	public Player getPlayer1() {
		return player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setWinner(Label player) {
		winnerPlayer.getLabel().setText(player.getText());
		
	}


}
