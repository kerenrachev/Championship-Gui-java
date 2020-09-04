import Controller.Controller;
import Model.Model;
import View.FirstView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Program extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Model theModel = new Model();
		FirstView theView = new FirstView(primaryStage);
		Controller TheController = new Controller(theModel, theView);
	}
}
