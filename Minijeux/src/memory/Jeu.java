package memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;


import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import menu.Menu;




public class Jeu extends Application {

	private int NbreParLigne;
	private Carte CarteSelectionnee = null;
	private int NbreClicks = 2;
	ToggleGroup group = new ToggleGroup();

	private Parent createContent1() {
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
			Node source = (Node) e.getSource();
			Stage window = (Stage) source.getScene().getWindow();
			window.setScene(new Scene(createContent2()));
		});

		retour.setOnAction(e -> {
			menu.Menu.main(null);
		});

		ToggleGroup group = new ToggleGroup();

		RadioButton button1 = new RadioButton("4");
		button1.setToggleGroup(group);
		button1.setOnAction( e -> {
			NbreParLigne = 4;
		});
		
		RadioButton button2 = new RadioButton("12");
		button2.setToggleGroup(group);
		button2.setOnAction( e -> {
			NbreParLigne = 12;
		});
		
		RadioButton button3 = new RadioButton("24");
		button3.setToggleGroup(group);
		button3.setOnAction( e -> {
			NbreParLigne = 24;
		});

		RadioButton button4 = new RadioButton("30");
		button4.setToggleGroup(group);
		button4.setOnAction( e -> {
			NbreParLigne = 30;
		});

		VBox menuButtons = new VBox(5);
		menuButtons.getChildren().addAll(button1,button2,button3,button4);

		root.getChildren().addAll(text,menuButtons,text2,start,retour);

		menuButtons.setLayoutX(350);
		menuButtons.setLayoutY(260);

		return root;
	}

	private Parent createContent2() {
		Pane root = new Pane();
		root.setPrefSize(800, 600);	

		Button menuu = new Button("Menu");
		Button quit = new Button("Quitter");
		Button score = new Button("Score");
		Button retour = new Button("Retour");

		retour.setLayoutX(150);
		retour.setLayoutY(500);
		menuu.setLayoutX(300);
		menuu.setLayoutY(500);
		quit.setLayoutX(450);
		quit.setLayoutY(500);
		score.setLayoutX(600);
		score.setLayoutY(500);

		menuu.setPrefSize(100, 50);
		quit.setPrefSize(100, 50);
		score.setPrefSize(100, 50);
		retour.setPrefSize(100, 50);
		
		retour.setOnAction(e -> {
			Node source = (Node) e.getSource();
			Stage window = (Stage) source.getScene().getWindow();
			window.setScene(new Scene(createContent1()));
		});
		menuu.setOnAction(e -> {
			menu.Menu.main(null);
		});

		quit.setOnAction(e -> {
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
			Alert dialog = new Alert(AlertType.INFORMATION);
			dialog.setTitle("Jeu Memory");
			dialog.setContentText("Vous allez etre redirigé vers les scores");
			dialog.showAndWait();
			resultat.Main.main(null); //afficher la page de scores
		});

		Image im1 = new Image("chaton.jpg",200,200,false,false);
		Image im2 = new Image("chiot.jpg",200,200,false,false);
		Image im3 = new Image("lapin.jpg",200,200,false,false);
		Image im4 = new Image("chevre.jpg",200,200,false,false);
		Image im5 = new Image("phoque.jpg",200,200,false,false);
		Image im6 = new Image("giraffe.jpeg",200,200,false,false);
		Image im7 = new Image("singe.jpeg",200,200,false,false);
		Image im8 = new Image("renard.jpeg",200,200,false,false);
		Image im9 = new Image("tigre.jpeg",200,200,false,false);
		Image im10 = new Image("elephant.jpeg",200,200,false,false);
		Image im11 = new Image("ecureuil.jpeg",200,200,false,false);
		Image im12 = new Image("lion.jpg",200,200,false,false);

		Image images[] = {im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11,im12};

		ArrayList<Carte> cartes = new ArrayList<>();
		for (int i=0; i<NbreParLigne; i++) {
			cartes.add(new Carte(images[i]));
			cartes.add(new Carte(images[i]));
		}

		Collections.shuffle(cartes); //melanger les images

		for (int i = 0; i < cartes.size(); i++) {
			Carte c = cartes.get(i);
			c.setTranslateX(200 * (i % NbreParLigne));
			c.setTranslateY(200 * (i / NbreParLigne));
			root.getChildren().add(c);
		} //afficher les images

		root.getChildren().addAll(quit,score,menuu,retour);

		return root;

	}

	@Override
	public void start(Stage Pstage) throws Exception{
		Pstage.setTitle("Jeu Memory");
		Pstage.setScene(new Scene(createContent1()));
		Pstage.show();

	}

	public class Carte extends StackPane{
		private ImageView iw = new ImageView();

		public Carte(Image img) {
			Rectangle bord = new Rectangle(200,200);
			bord.setFill(Color.TEAL);
			bord.setStroke(Color.BLACK);

			iw.setImage(img);

			setAlignment(Pos.CENTER);
			getChildren().addAll(bord, iw);

			setOnMouseClicked(event -> { //retourner la carte lors du click
				if (CarteRetournee() || NbreClicks == 0 )
					return;
				NbreClicks --;

				if (CarteSelectionnee == null) {
					CarteSelectionnee = this;  //la carte selectionnee n'est plus egale a null
					RetournerCarte(()-> {}); //ne fait rien
				}

				else {
					RetournerCarte(() -> {
						if (!MemeCarte(CarteSelectionnee)) {
							CarteSelectionnee.FaceCachee();
							this.FaceCachee();
					
						}
						CarteSelectionnee = null; //re initialiser la carte
						NbreClicks = 2;


					});
				}

			});
			FaceCachee();
		}


		public boolean CarteRetournee() { //si opacite=1 return true donc la carte est retournee
			return iw.getOpacity()==1;
		}
		public void RetournerCarte(Runnable action) {
			FadeTransition t = new FadeTransition(Duration.seconds(0.2), iw);
			t.setToValue(1); //Montrer l'image opacite=1
			t.setOnFinished(e -> action.run()); //action executee quand la carte a ete retournee 
			t.play();
		}

		public void FaceCachee() {
			FadeTransition t = new FadeTransition(Duration.seconds(0.2), iw);
			t.setToValue(0); //cacher l'image opacite=0
			t.play();
		}

		public boolean MemeCarte(Carte to) {
			return iw.getImage().equals(to.iw.getImage()); //comparer les deux cartes
		}
	}


	public static void main(String[] args) {
		launch(args);
	}
}