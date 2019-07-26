package memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javafx.animation.Animation.Status;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Jeu extends Parent {
	
	
	public  Jeu (Stage stage, Label GameOver, Label label, Label lb) {
		
		
		Pane root = new Pane();
		root.setPrefSize(800, 600);
		
		GameOver = new Label("Game over !");
		GameOver.setVisible(false);
		GameOver.setLayoutX(300);
		GameOver.setLayoutY(400);
		GameOver.setFont(Font.font(40));
		GameOver.setTextFill(Color.RED);
		
		label = new Label("Vous avez gagné !");
		label.setVisible(false);
		label.setLayoutX(300);
		label.setLayoutY(400);
		label.setFont(Font.font(30));
		label.setTextFill(Color.DARKBLUE);
		
		//CHRONO

		lb= new Label("Temps : " + Main.seconds.toString());
		lb.setLayoutX(350);
		lb.setLayoutY(450);
		lb.setFont(Font.font(30));

		//BOUTONS

		Button rejouer = new Button("Rejouer");
		Button menu = new Button("Menu");
		Button quit = new Button("Quitter");
		Button score = new Button("Score");
		Button retour = new Button("Retour");

		rejouer.setLayoutX(50);
		rejouer.setLayoutY(500);
		retour.setLayoutX(200);
		retour.setLayoutY(500);
		menu.setLayoutX(350);
		menu.setLayoutY(500);
		quit.setLayoutX(500);
		quit.setLayoutY(500);
		score.setLayoutX(650);
		score.setLayoutY(500);

		rejouer.setPrefSize(100, 50);
		menu.setPrefSize(100, 50);
		quit.setPrefSize(100, 50);
		score.setPrefSize(100, 50);
		retour.setPrefSize(100, 50);
		
		rejouer.setOnAction(e -> {
			if (Main.time.getStatus() == Status.RUNNING) {
				Main.time.stop();
			}
			Main.s.play();
			Alert dialogC = new Alert(AlertType.CONFIRMATION);
			dialogC.setTitle("Jeu Memory");
			dialogC.setHeaderText(null);
			dialogC.setContentText("Voulez-vous rejouer ?");
			Optional<ButtonType> answer = dialogC.showAndWait();
			
			if (answer.get() == ButtonType.OK) {
				stage.setScene(new Scene(new Jeu(stage, Main.GameOver, Main.label, Main.lb)));
				Main.seconds = 0;
				Main.time.playFromStart();

			}
			else {
				Main.time.play();
			}
		});

		retour.setOnAction(e -> {
			if (Main.time.getStatus() == Status.RUNNING) {
				Main.time.stop();
			}
			Main.s.play();
			stage.setScene(new Scene(new Fenetre(stage)));
		});

		menu.setOnAction(e -> {
			if (Main.time.getStatus() == Status.RUNNING) {
				Main.time.stop();
			}

			Main.s.play();
			//menu.Main.main(null);
			stage.setScene(new Scene(new Jeu(stage, Main.GameOver, Main.label, Main.lb)));
			stage.close();
		});

		quit.setOnAction(e -> {
			if (Main.time.getStatus() == Status.RUNNING) {
				Main.time.stop();
			}

			Main.s.play();
			Alert dialogC = new Alert(AlertType.CONFIRMATION);
			dialogC.setTitle("Jeu Memory");
			dialogC.setHeaderText(null);
			dialogC.setContentText("Voulez-vous vraiment quitter ?");
			Optional<ButtonType> answer = dialogC.showAndWait();
			if (answer.get() == ButtonType.OK) {
				Node source = (Node) e.getSource();
				Stage window = (Stage) source.getScene().getWindow();
				window.close(); //quitter le jeu
			}
		});

		score.setOnAction(e -> {
			Main.s.play();
			stage.setScene(new Scene(new Jeu(stage, Main.GameOver, Main.label, Main.lb)));
			stage.close();
			resultat2.Main.main(null);
		});
		
		//MISE EN PLACE DES IMAGES

				Image im1 = new Image("resources/memory/chaton.jpg",100,100,false,false);
				Image im2 = new Image("resources/memory/chiot.jpg",100,100,false,false);
				Image im3 = new Image("resources/memory/lapin.jpg",100,100,false,false);
				Image im4 = new Image("resources/memory/chevre.jpg",100,100,false,false);
				Image im5 = new Image("resources/memory/phoque.jpg",100,100,false,false);
				Image im6 = new Image("resources/memory/giraffe.jpeg",100,100,false,false);
				Image im7 = new Image("resources/memory/singe.jpeg",100,100,false,false);
				Image im8 = new Image("resources/memory/renard.jpeg",100,100,false,false);
				Image im9 = new Image("resources/memory/tigre.jpeg",100,100,false,false);
				Image im10 = new Image("resources/memory/elephant.jpeg",100,100,false,false);
				Image im11 = new Image("resources/memory/ecureuil.jpeg",100,100,false,false);
				Image im12 = new Image("resources/memory/lion.jpg",100,100,false,false);

				Image images[] = {im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11,im12};

				ArrayList<Carte> cartes = new ArrayList<>();
				for (int i=0; i<Main.NbreDePairs; i++) {
					cartes.add(new Carte(images[i]));
					cartes.add(new Carte(images[i]));
				}

				Collections.shuffle(cartes); //melanger les images

				for (int i = 0; i < cartes.size(); i++) {
					Carte c = cartes.get(i);
					c.setTranslateX(100 * (i % Main.NbreParLigne));
					c.setTranslateY(100 * (i / Main.NbreParLigne));
					root.getChildren().add(c);
				} //afficher les images

				this.getChildren().addAll(quit,score,menu,retour,rejouer,lb,label,GameOver);
		
		
	}

}
