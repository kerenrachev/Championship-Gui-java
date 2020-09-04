package Model;


import java.awt.Insets;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player{

	private Label label;
	private int x;
	private int y;
	
	public Player() {
		this(0,0);
	}
	public Player(int x,int y) {
		this.x=x;
		this.y=y;
		label=new Label("");
		label.setBackground(new Background(new BackgroundFill (Color.WHITE, null, null)));
		DropShadow shadow= new DropShadow(15, Color.DARKBLUE);
		label.setEffect(shadow);
		label.setMinSize(165, 31);
		label.setAlignment(Pos.CENTER);
        label.setLayoutX(x);
        label.setLayoutY(y);
	}
	public Label getLabel() {
		return label;
	}
	public void show(Group root) {
		root.getChildren().add(label);
	}
	public void setLabel(String text) {
		this.label.setText(text);
		
	}
	public int getX() {
		return x;
		
	}
	private int getY() {
		return y;
	}
}
