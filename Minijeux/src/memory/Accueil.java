package memory;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import memory.Jeu;
import menu.Menu;

public class Accueil extends Application {

	ToggleGroup group = new ToggleGroup();

	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(800, 600);	

		Text text = new Text(250,200,"Jeu Memory");
		text.setFont(Font.font("Helvetica", FontWeight.BOLD, 50));
		text.setStroke(Color.TURQUOISE);
		text.setFill(Color.BLACK);

		Text text2 = new Text(250,240,"Choisissez le nombre de cartes : ");
		text2.setFont(Font.font("Helvetica", FontWeight.NORMAL, 20));


		Button start = new Button("Commencer");
		Button retour = new Button("Retour");

		retour.setLayoutX(250);
		retour.setLayoutY(370);
		start.setLayoutX(400);
		start.setLayoutY(370);

		start.setPrefSize(100, 50);
		retour.setPrefSize(100, 50);

			start.setOnAction(e -> {
				memory.Jeu.main(null);
				//Jeu a = new Jeu();
				//Node source = (Node) e.getSource();
				//Stage window = (Stage) source.getScene().getWindow(); 
				//window.getScene().setRoot(a.getRoot());
				//window.show();


		});

		

		retour.setOnAction(e -> {
			menu.Menu.main(null);
		});

		ToggleGroup group = new ToggleGroup();

		RadioButton button1 = new RadioButton("4");
		button1.setToggleGroup(group);
		button1.setSelected(true);

		RadioButton button2 = new RadioButton("12");
		button2.setToggleGroup(group);

		RadioButton button3 = new RadioButton("24");
		button3.setToggleGroup(group);

		RadioButton button4 = new RadioButton("30");
		button4.setToggleGroup(group);

		VBox menuButtons = new VBox(5);
		menuButtons.getChildren().addAll(button1,button2,button3,button4);

		root.getChildren().addAll(text,menuButtons,text2,start,retour);

		menuButtons.setLayoutX(350);
		menuButtons.setLayoutY(260);


		return root;
	}


	public int choix() {

		RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
		String toggleValue = selectedRadioButton.getText();
		if (toggleValue == "4") {
			return 4;
		}
		if (toggleValue == "12") {
			return 12;
		}
		if (toggleValue == "24") {
			return 24;
		}
		else {
			return 30;
		}
	}

	@Override
	public void start(Stage stage) throws Exception{
		stage.setTitle("Jeu Memory");
		stage.setScene(new Scene(createContent()));
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
