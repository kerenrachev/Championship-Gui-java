package View;

import java.util.ArrayList;

import Model.BasketballGame;
import Model.Game;
import Model.Model;
import Model.Player;
import Model.SoccerGame;
import Model.TennisGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ThirdView {

	private Label tieInstructons;
	private Label player1;
	private Label player2;
	private Label nameOfGame;    //For me to see that OnAction handler knows what type of game it is
	private TextField t1;
	private TextField t2;
	private TextField t3;
	private TextField t4;
	private TextField t5;
	private TextField t6;
	private TextField t7;
	private TextField t8;
	private TextField t9;
	private TextField t10;
	private Group root;
	private ArrayList<TextField> textFieldArray;
	private Button doneButton;
	private boolean allTextFieldsAreFull;
	private Stage scoringStage;
	
	public ThirdView(Model theModel,Label l1, Label l2) {
		
		scoringStage= new Stage();
		root= new Group();
		tieInstructons= new Label("");
		player1= new Label(l1.getText());
		player2= new Label(l2.getText());
		player1.setLayoutX(100);
		player1.setLayoutY(100);
		player2.setLayoutX(100);
		player2.setLayoutY(200);
		root.getChildren().add(player1);
		root.getChildren().add(player2);
		
		
		t1= new TextField();
		t2= new TextField();
		t3= new TextField();
		t4= new TextField();
		t5= new TextField();
		t6= new TextField();
		t7= new TextField();
		t8= new TextField();
		t9= new TextField();
		t10= new TextField();
		textFieldArray = new ArrayList<>();
		textFieldArray.add(t1);
		textFieldArray.add(t2);
		textFieldArray.add(t3);
		textFieldArray.add(t4);
		textFieldArray.add(t5);
		textFieldArray.add(t6);
		textFieldArray.add(t7);
		textFieldArray.add(t8);
		textFieldArray.add(t9);
		textFieldArray.add(t10);
		for(int i=0;i<textFieldArray.size();i++) {
			textFieldArray.get(i).setMaxHeight(20);
			textFieldArray.get(i).setMaxWidth(40);
		}
		addTextFields(theModel);	
		doneButton = new Button ("Done");
		doneButton.setLayoutX(270);
		doneButton.setLayoutY(350);
		doneButton.setDisable(true);
		addElementsByGameType(theModel);
		root.getChildren().add(doneButton);
		Pane drawPane= new Pane();
		drawPane.getChildren().addAll(root);
		Scene gameScene = new Scene (drawPane, 600,400);
		scoringStage.setScene(gameScene);
		scoringStage.show();
		
	}
	private void addTextFields(Model theModel) {
		int startValueX=130;
		int startValueY=100;
		int addValueX=70;
		int addValueY=100;
		for(int i=0;i<theModel.returnNumOfTextFieldsByGameType()*2;i++) {

			textFieldArray.get(i).setLayoutX(startValueX+addValueX);
			textFieldArray.get(i).setLayoutY(startValueY);
			
			textFieldArray.get(i+1).setLayoutX(startValueX+addValueX);
			textFieldArray.get(i+1).setLayoutY(startValueY+addValueY);
			addValueX+=70;
			root.getChildren().add(textFieldArray.get(i));
			root.getChildren().add(textFieldArray.get(i+1));
			i++;
		}
	}
	private void addElementsByGameType(Model theModel) {
		Label nameOfGame= new Label("");
		if(theModel.getTypeOfGame().equalsIgnoreCase("soccer")) {
			nameOfGame.setText("Soccer Game");
			
		}
        if(theModel.getTypeOfGame().equalsIgnoreCase("basketball")) {
        	nameOfGame.setText("BasketBall Game");
        }
        if(theModel.getTypeOfGame().equalsIgnoreCase("tennis")) {
        	nameOfGame.setText("Tennis Game");
        }
        nameOfGame.setLayoutX(200);
        nameOfGame.setFont(new Font(30));
        nameOfGame.setTextFill(Color.SANDYBROWN);
    //    Shadow dropShadow = new Shadow(10,Color.DARKKHAKI);
    //    nameOfGame.setEffect(dropShadow);
        root.getChildren().add(nameOfGame);
        
		
	}
	public Button getButton() {
		return doneButton;
	}
	public ArrayList <TextField> getTextFieldArray(){
		return textFieldArray;
	}
	public void update(Model theModel, String s) {
		doneButton.setDisable(true);
		if(s.equalsIgnoreCase("")) {
			allTextFieldsAreFull=true;
			for(int i=0;i<theModel.returnNumOfTextFieldsByGameType()*2;i++) {
				if(textFieldArray.get(i).getText().isEmpty()) {
					allTextFieldsAreFull=false;
				}
			}
			if(allTextFieldsAreFull) {
				doneButton.setDisable(false);
			}
		}
		else {
			for(int i=0;i<6;i++) {
				if(textFieldArray.get(i).getText().isEmpty()) {
					allTextFieldsAreFull=false;
				}
			}
			if(allTextFieldsAreFull) {
				doneButton.setDisable(false);
			}
		}
	}

	public Stage getStage() {
		return scoringStage;
	}

	public void addAnotherTextFields(Model theModel,int index) {
			textFieldArray.get(4).setLayoutX(340);
			textFieldArray.get(4).setLayoutY(100);
			
			textFieldArray.get(5).setLayoutX(340);
			textFieldArray.get(5).setLayoutY(200);
			root.getChildren().addAll(textFieldArray.get(4),textFieldArray.get(5));
	
		update(theModel,"add");
		
	}
	public Group getRoot() {
		return root;
	}
	public void addTieInstuctions() {
		tieInstructons.setText("There was a tie. Another half has been added . Good luck!!!");
		tieInstructons.setLayoutX(100);
		tieInstructons.setLayoutY(50);
		root.getChildren().add(tieInstructons);
		
	}
}
