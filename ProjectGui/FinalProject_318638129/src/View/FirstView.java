package View;

import java.util.ArrayList;

import Model.Model;
import Model.Player;
import javafx.beans.value.ChangeListener;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FirstView implements ViewManager {
    private Group root;
    private RadioButton tennis,basketball, soccer;
    private ToggleGroup tg;
    private BorderPane bp;
    private Button addParticipant;
    private Button startChampionship ;
    private TextField textField ;
    private boolean textFieldIsEmpty;
    private ArrayList <Button> buttonArray;
    
    
	public FirstView(Stage primaryStage) {
		textFieldIsEmpty=true;
		root= new Group();
		tg= new ToggleGroup();
		tennis = new RadioButton("Tennis");
		tennis.setSelected(true);
		tennis.setToggleGroup(tg);
		basketball = new RadioButton("Basketball");
		basketball.setToggleGroup(tg); 
		soccer = new RadioButton ("Soccer");
		soccer.setToggleGroup(tg);
		
		VBox vbTop= new VBox();
		DropShadow dropShadow= new DropShadow(10, Color.DEEPPINK);
		Label title= new Label("Championship");
		title.setEffect(dropShadow);
		title.setTextFill(Color.WHITESMOKE);
		Label instructions = new Label("\n"+"Please choose the type of chamionship and 8 players, and then press START CHAMPIONSHIP button.");
		instructions.setFont(new Font (15));
		title.setFont(new Font(50));
		vbTop.getChildren().addAll(title,instructions);
		vbTop.setAlignment(Pos.BOTTOM_CENTER);
		
		GridPane gpRoot= new GridPane();
		gpRoot.setPadding(new Insets (4));
		gpRoot.setAlignment(Pos.CENTER);
		gpRoot.setGridLinesVisible(false);
		gpRoot.setHgap(10);
		gpRoot.setVgap(10);
		Label labelName = new Label("Name:");
		textField = new TextField ();
		addParticipant = new Button ("Add participant");
		startChampionship = new Button ("Start championship");
		gpRoot.add(labelName,0,0);
		gpRoot.add(textField,1,0);
		gpRoot.add(addParticipant,0,1);
		gpRoot.add(startChampionship,1,1);
		
        VBox draw =new VBox();
        draw.getChildren().add(root);
        
      
		VBox vbRigh= new VBox ();
		vbRigh.getChildren().addAll(tennis,basketball,soccer);
		vbRigh.setAlignment(Pos.CENTER_LEFT);
		

		bp= new BorderPane();
		bp.setRight(vbRigh);
		bp.setLeft(draw);
		bp.setCenter(gpRoot);
		bp.setTop(vbTop);
		
		
		Scene scene= new Scene (bp, 1200,700);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}

	public Button getAddButton() {
		return addParticipant;
		
	}
	public Button getStartButton() {
		return startChampionship;
	}
    
	public TextField getTextFiled() {
		return textField;
	}
	public void setTextFieldIsEmpty(boolean value) {
		textFieldIsEmpty=value;
	}

	public void addLabel(Label l) {
		root.getChildren().add(l);
	}

	public String getKindOfChampionship() {
		if(soccer.isSelected()) {
			return "Soccer";
		}
		if(basketball.isSelected()) {
			return "Basketball";
		}
		else {
			return "Tennis";
		}
		
	}

	public void addChangeListenerToToggleGroup(ChangeListener<Toggle> chl) {
		tg.selectedToggleProperty().addListener(chl);
	}

	@Override
	public void update(Model theModel) {
		if(textField.getText().isEmpty()) {
			addParticipant.setDisable(true);
		}
		else {
			addParticipant.setDisable(false);;
		}
		if(theModel.getCurrentNumOfParticipants()<8) {
			startChampionship.setDisable(true);
		}
		else {
			startChampionship.setDisable(false);
			addParticipant.setDisable(true);
		}
	    theModel.show(root);
	}

	public ArrayList<Button> getButtonArray() {
		return buttonArray;
	}
}
