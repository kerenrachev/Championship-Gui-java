package View;

import java.util.ArrayList;

import Model.Game;
import Model.Model;
import Model.Player;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SecondView implements ViewManager{
	private ArrayList <Button> buttonArray;
	private ArrayList <Player> playersArray;
	private Player l1;
	private Player l2;                    
	private Player l3;
	private Player l4;
	private Player l5;
	private Player l6;
	private Player l7;
	private int counter;

	public SecondView(ArrayList<Player> arrayList) {
		playersArray = new ArrayList <>();
		Stage scoringStage= new Stage();
		Group root= new Group();
		
		for(int i=0;i<arrayList.size();i++) {
			playersArray.add(arrayList.get(i));
			root.getChildren().add(arrayList.get(i).getLabel());
		}
		counter=0;
		Label title= new Label("Scoring");
		DropShadow shadow = new DropShadow(10,Color.DEEPPINK);
		title.setEffect(shadow);
		title.setFont(new Font(50));
		title.setTextFill(Color.WHITE);
		title.setLayoutX(500);
		root.getChildren().add(title);
		
		Player l1= new Player(400,145);
		Player l2= new Player(400,261);                    
		Player l3= new Player(400,378);
		Player l4= new Player(400,495);
		Player l5= new Player(720,205);
		Player l6= new Player(720,430);
		Player l7= new Player(980,320);
		playersArray.add(l1);
		playersArray.add(l2);
		playersArray.add(l3);
		playersArray.add(l4);
		playersArray.add(l5);
		playersArray.add(l6);
		playersArray.add(l7);
		
		Line line1= new Line(220,125.5,300,125.5);
		Line line2= new Line(220,185,300,185);
		Line line3= new Line(220,244.5,300,244.5);
		Line line4= new Line(220,304,300,304);
		Line line5= new Line(220,363.5,300,363.5);
		Line line6= new Line(220,423,300,423);
		Line line7= new Line(220,482.5,300,482.5);
		Line line8= new Line(220,542,300,542);
		
		Line line9= new Line(300,125.5,300,185);
		Line line10= new Line(300,244.5,300,304);
		Line line11= new Line(300,363.5,300,423);
		Line line12= new Line(300,482.5,300,542);
		
		Line line13= new Line(300,155.25,400,155.25);
		Line line14= new Line(300,271.75,400,271.75);
		Line line15= new Line(300,391.25,400,391.25);
		Line line16= new Line(300,510.25,400,510.25);
		
		Line line17= new Line(570,155.25,660,155.25);
		Line line18= new Line(570,271.75,660,271.75);
		Line line19= new Line(570,391.25,660,391.25);
		Line line20= new Line(570,510.25,660,510.25);
		
		Line line21= new Line(660,155.25,660,271.75);
		Line line22= new Line(660,391.25,660,510.25);
		
		Line line23= new Line(660,213.5,720,213.5);
		Line line24= new Line(660,450.75,720,450.75);
		
		Line line25= new Line(888,213.5,930,213.5);
		Line line26= new Line(888,450.75,930,450.75);
		
		Line line27= new Line(930,213.5,930,450.75);
		Line line28= new Line(930,332.125,980,332.125);
		
		Button b1=new Button ("Play Game!");
		Button b2=new Button ("Play Game!");
		Button b3=new Button ("Play Game!");
		Button b4=new Button ("Play Game!");
		Button b5=new Button ("Play Game!");
		Button b6=new Button ("Play Game!");
		Button b7=new Button ("Play Game!");
		
		
		b1.setLayoutX(270);
		b1.setLayoutY(140.25);
		b2.setLayoutX(270);
		b2.setLayoutY(256.75);
		b3.setLayoutX(270);
		b3.setLayoutY(376.25);
		b4.setLayoutX(270);
		b4.setLayoutY(495.25);
		b5.setLayoutX(615);
		b5.setLayoutY(198.5);
		b6.setLayoutX(615);
		b6.setLayoutY(435.75);
		b7.setLayoutX(875);
		b7.setLayoutY(317.125);
		this.buttonArray= new ArrayList<Button>();
		buttonArray.add(b1);
		buttonArray.add(b2);
		buttonArray.add(b3);
		buttonArray.add(b4);
		buttonArray.add(b5);
		buttonArray.add(b6);
		buttonArray.add(b7);
		b5.setDisable(true);
		b6.setDisable(true);
		b7.setDisable(true);
	
		root.getChildren().addAll(l1.getLabel(),l2.getLabel(),l3.getLabel(),l4.getLabel(),l5.getLabel(),l6.getLabel(),l7.getLabel(),line1,
				line2,line3,line4,line5,line6,line7,line8,line9,line10,line11,line12,line13,line14,line15,line16,line17,line18,line19,
				line20,line21,line22,line23,line24,line25,line26,line27,line28,b1,b2,b3,b4,b5,b6,b7);
		
		Pane drawPane= new Pane();
		drawPane.getChildren().add(root);
		Scene scoringScene = new Scene (drawPane, 1200,700);
		scoringStage.setScene(scoringScene);
		scoringStage.show();
	}
	
	public ArrayList<Button> getButtonArray() {
		return buttonArray;
	}
	@Override
	public void update(Model theModel) {
		int j=0;
		for(int i=0;i<playersArray.size();i++) {
		    if((!playersArray.get(i).getLabel().getText().isEmpty())&&(i!=playersArray.size()-1)&&
		    		(!playersArray.get(i+1).getLabel().getText().isEmpty())&&i!=playersArray.size()-1) {
					buttonArray.get(j).setDisable(false);
			}
			j++;
			i++;
		}
		for(int i=8; i<playersArray.size();i++) {
			if(!playersArray.get(i).getLabel().getText().isEmpty()) {
				buttonArray.get(i-8).setDisable(true);
			}
		}
		
	}
	public void setWinners(int k, Label winner) {
		playersArray.get(k).getLabel().setText(winner.getText());
		
	}
	public ArrayList<Player> getPlayersArrayList() {
		return playersArray;
	}

	public void setEachButtonToReleventGame(Model theModel) {
		
		for(int i=0;i<buttonArray.size();i++) {
		     
		}
		
	}

	public Game initializeAllGames(Model theModel, Game game, Button button, int index, int num) {
		Player p1= playersArray.get(index);
		Player p2= playersArray.get(index+1);
		Player winner= playersArray.get(index+num);
		return theModel.initializeAllGames(p1,p2,winner,button,game);
		
	}
}
