package memory;

import javafx.animation.Timeline;
import javafx.animation.Animation.Status;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Fenetre extends Parent {
	
	public Fenetre (Stage stage) {
		Pane root = new Pane();
		root.setPrefSize(800, 600);	
		
		Main.time.setCycleCount(Timeline.INDEFINITE);

		LinearGradient lg = new LinearGradient(0,0,0,1,true,CycleMethod.NO_CYCLE,new Stop(0.3f,Color.LAVENDER),new Stop(0.75f,Color.PLUM));
		root.setBackground(new Background(new BackgroundFill(lg, CornerRadii.EMPTY, Insets.EMPTY)));

		Text text = new Text(250,200,"Jeu Memory");
		text.setFont(Font.font("Helvetica", FontWeight.BOLD, 50));
		text.setStroke(Color.TURQUOISE);
		text.setFill(Color.BLACK);

		Text text2 = new Text(250,240,"Choisissez le nombre de cartes : ");
		text2.setFont(Font.font("Helvetica", FontWeight.NORMAL, 20));

		Image on = new Image("resources/memory/on.png",50,50,false,false);
		Image off = new Image("resources/memory/off.png",50,50,false,false);
		ImageView iwOn = new ImageView(on);
		ImageView iwOff = new ImageView(off);
		iwOn.setVisible(false);

		iwOn.setOnMouseClicked(e -> {
			iwOn.setVisible(false);
			iwOff.setVisible(true);
			Main.intro.stop();
		});

		iwOff.setOnMouseClicked(e -> {
			iwOff.setVisible(false);
			iwOn.setVisible(true);
			Main.intro.playNonStop();
		});

		Button start = new Button("Commencer");
		Button retour = new Button("Retour");

		retour.setLayoutX(250);
		retour.setLayoutY(370);
		start.setLayoutX(400);
		start.setLayoutY(370);

		start.setPrefSize(100, 50);
		retour.setPrefSize(100, 50);

		start.setOnAction(e -> { 
			if (Main.time.getStatus() == Status.STOPPED || Main.time.getStatus() == Status.PAUSED  ) {
				Main.time.playFromStart();
			}
			Main.seconds = 0;
			Main.s.play();
			Node source = (Node) e.getSource();
			Stage window = (Stage) source.getScene().getWindow();
			window.setScene(new Scene(new Jeu(stage, Main.GameOver, Main.label, Main.lb)));
		});

		retour.setOnAction(e -> {
			Main.s.play();
			menu.Main.main(null);
			Node source = (Node) e.getSource();
			Stage window = (Stage) source.getScene().getWindow();
			window.setScene(new Scene(new Jeu(stage, Main.GameOver, Main.label, Main.lb)));
			window.close();
		});

		ToggleGroup group = new ToggleGroup();

		RadioButton button1 = new RadioButton("8");
		button1.setToggleGroup(group);
		button1.setOnAction( e -> {
			Main.NbreDePairs = 4;
			Main.NbreParLigne = 4;
			Main.s.play();
		});

		RadioButton button2 = new RadioButton("10");
		button2.setToggleGroup(group);
		button2.setOnAction( e -> {
			Main.NbreDePairs = 5;
			Main.NbreParLigne = 5;
			Main.s.play();
		});

		RadioButton button3 = new RadioButton("14");
		button3.setToggleGroup(group);
		button3.setOnAction( e -> {
			Main.NbreDePairs = 7;
			Main.NbreParLigne = 7;
			Main.s.play();
		});

		RadioButton button4 = new RadioButton("24");
		button4.setToggleGroup(group);
		button4.setOnAction( e -> {
			Main.NbreDePairs = 12;
			Main.NbreParLigne = 8;
			Main.s.play();
		});

		VBox menuButtons = new VBox(5);
		menuButtons.getChildren().addAll(button1,button2,button3,button4);

		root.getChildren().addAll(text,menuButtons,text2,start,retour,iwOn,iwOff);

		menuButtons.setLayoutX(350);
		menuButtons.setLayoutY(260);

		
	}

}
