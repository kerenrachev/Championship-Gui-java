package View;

import Model.Model;
import Model.Player;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FourthView {

	private Label player1;
	private Label player2;
	private Label tie;
	private Stage tieBreakerStage;
	private Group root;
	private CheckBox checkBoxP1;
	private CheckBox checkBoxP2;
	private Button done;
	private int round;
	private Label roundNum;
	
	
	public FourthView(Label l1, Label l2, Model theModel) {
		tieBreakerStage= new Stage();
		root= new Group();
		round=1;
		roundNum= new Label("Round 1 :");
		roundNum.setLayoutX(280);
		roundNum.setLayoutY(90);
		roundNum.setFont(new Font(25));
		tie= new Label ("tie");
		Label tieBreaker= new Label ("Tie Breaker");
		tieBreaker.setAlignment(Pos.TOP_CENTER);
		tieBreaker.setTextFill(Color.WHITE);
		tieBreaker.setFont(new Font(35));
		tieBreaker.setLayoutX(200);
		DropShadow dropShadow= new DropShadow(10, Color.ROYALBLUE);
		tieBreaker.setEffect(dropShadow);
	    Label instructions = new Label ("The game ended in a draw. Penalty kicks will start now,"
	    		+ "\n please choose which of the players scored.");
	    instructions.setLayoutX(50);
	    instructions.setLayoutY(50);
	    checkBoxP1= new CheckBox();
	    checkBoxP2= new CheckBox();
	    checkBoxP1.setLayoutX(240);
	    checkBoxP1.setLayoutY(100);
	    checkBoxP2.setLayoutX(240);
	    checkBoxP2.setLayoutY(200);
		player1= new Label(l1.getText());
		player2= new Label(l2.getText());
		player1.setLayoutX(100);
		player1.setLayoutY(100);
		player2.setLayoutX(100);
		player2.setLayoutY(200);
		done= new Button  ("Done");
		done.setLayoutX(250);
		done.setLayoutY(300);
		root.getChildren().addAll(player1,player2,checkBoxP1,checkBoxP2,done,instructions,roundNum);
		
		
		Pane drawPane= new Pane();
		drawPane.getChildren().addAll(root,tieBreaker);
		Scene gameScene = new Scene (drawPane, 600,400);
		tieBreakerStage.setScene(gameScene);
		tieBreakerStage.show();
		
		

	}
	public Label checkWhoWins() {
		if(checkBoxP1.isSelected()&&checkBoxP2.isSelected()) {
			return tie;	
		}
		if(checkBoxP1.isSelected()) {
			return player1;
		}
		if(checkBoxP2.isSelected()) {
			return player2;
		}
		else return tie;
	}
	public void update() {
		round++;
		String s= "Round "+ round + " :";
		roundNum.setText(s);
		
	}
	public Button getButton() {
		return done;
	}
	public Stage getStage() {
		return tieBreakerStage;
	}
	public CheckBox getCh1() {
		return checkBoxP1;
	}
	public CheckBox getCh2() {
		return checkBoxP2;
	}

}
