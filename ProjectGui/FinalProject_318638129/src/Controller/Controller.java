package Controller;
import Model.Game;
import Model.Model;
import Model.Player;
import Model.SoccerGame;
import View.FirstView;
import View.FourthView;
import View.SecondView;
import View.ThirdView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;

public class Controller {
	private Model theModel;
	private FirstView theView;
	private SecondView theView2;
	private ThirdView theView3;
	private int numOfParticipants;
	int k=0;
	
	public Controller(Model m, FirstView v) {
		numOfParticipants=0;
		theModel = m;
		theView = v;
		theView.update(theModel);
		theView.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				 theModel.getPlayersArray().get(numOfParticipants).getLabel().setText(theView.getTextFiled().getText());
				 numOfParticipants++;
				 theView.getTextFiled().clear();
				 theModel.setCurrentNum();
				 theView.update(theModel);
			}
		});
		ChangeListener<Toggle> chl = new ChangeListener<Toggle>() {

			@Override
		public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
			String typeOfChampionship = theView.getKindOfChampionship();
			theView.update(theModel);
			if(typeOfChampionship.equalsIgnoreCase("Soccer")) {
				theModel.startSoccer();
			}
			if(typeOfChampionship.equalsIgnoreCase("Tennis")) {
				theModel.startTennis();
			}
			if(typeOfChampionship.equalsIgnoreCase("Basketball")) {
				theModel.startBasketBall();
			}
		}};
	    theView.addChangeListenerToToggleGroup(chl);
		
		theView.getStartButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				theView2= new SecondView(theModel.getPlayersArray());
				int j=0;
				int num=8;
				for(int i=0;i<theView2.getButtonArray().size();i++) {
					Label l1= new Label (theView2.getPlayersArrayList().get(j).getLabel().getText());
					Label l2= new Label (theView2.getPlayersArrayList().get(j+1).getLabel().getText());
					Game game = new Game();
	                Game g= theView2.initializeAllGames(theModel,game, theView2.getButtonArray().get(i),j,num);

					theView2.getButtonArray().get(i).setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							theView3= new ThirdView(theModel,g.getPlayer1().getLabel(), g.getPlayer2().getLabel());
							theView3.getButton().setOnAction(new EventHandler<ActionEvent>() {
								
								@Override
								public void handle(ActionEvent event) {

									if(g.checkForTie(theView3.getTextFieldArray()) &&theModel.getTypeOfGame().equalsIgnoreCase("soccer")&&g.getHadAnotherHalf()==false) {
										g.setHadANotherHalf(true);
										theModel.setGameType("soccerThirdHalf");
										theView3.addAnotherTextFields(theModel,0);
										theView3.addTieInstuctions();
									}
									else if(g.checkForTie(theView3.getTextFieldArray())&&theModel.getTypeOfGame().equalsIgnoreCase("soccerThirdHalf")&&g.getHadAnotherHalf()==true) {
										FourthView theView4= new FourthView(g.getPlayer1().getLabel(), g.getPlayer2().getLabel(),theModel);
										theView4.getButton().setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent event) {
												String winner="";
													winner=theView4.checkWhoWins().getText().toString();
													System.out.println(winner);
													if (!winner.equalsIgnoreCase("tie")) {
														Label lw= new Label (winner);
														g.setWinner(lw);
														theView4.getStage().close();
													} 
													else {
														theView4.getCh1().setSelected(false);
														theView4.getCh2().setSelected(false);	
														theView4.update();
													}
													theView2.update(theModel);
													
													
											}
										});
										theModel.setGameType("soccer");
										theView3.getStage().close();
										theView2.update(theModel);
									}
									else {
											g.checkResults(theView3.getTextFieldArray());
											theView3.getStage().close();	
											if(theModel.getTypeOfGame().equalsIgnoreCase("soccerThirdHalf")) {
												theModel.setGameType("soccer");
											}
									
										
									}
									theView2.update(theModel);
								}
							});
							ChangeListener<String> c2= new ChangeListener<String>() {

								@Override
								public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
									theView3.update(theModel,"");
								}
							};
							for(int i=0;i<theView3.getTextFieldArray().size();i++) { 
								theView3.getTextFieldArray().get(i).textProperty().addListener(c2);
							}	
						}
					});
					j+=2;
					num--;
				}
				
			}
		});
		ChangeListener<String> c1= new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				theView.update(theModel);
			}
		};
		theView.getTextFiled().textProperty().addListener(c1);

		
		
	}

}
