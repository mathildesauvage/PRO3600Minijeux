package memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;


import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import menu.Menu;


public class Jeu extends Application {

	private int p;
	private int NbreParLigne;
	private Carte CarteSelectionnee = null;
	private int NbreClicks = 2;
	ToggleGroup group = new ToggleGroup();
	Sound s = new Sound("resources/toggle.mp3");

	private Parent createContent1() {
		Pane root = new Pane();
		root.setPrefSize(800, 600);	

		LinearGradient lg = new LinearGradient(0,0,0,1,true,CycleMethod.NO_CYCLE,new Stop(0.3f,Color.LAVENDER),new Stop(0.75f,Color.PLUM));
		root.setBackground(new Background(new BackgroundFill(lg, CornerRadii.EMPTY, Insets.EMPTY)));

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
			s.play();
			Node source = (Node) e.getSource();
			Stage window = (Stage) source.getScene().getWindow();
			window.setScene(new Scene(createContent2()));
		});

		retour.setOnAction(e -> {
			s.play();
			menu.Menu.main(null);
		});

		ToggleGroup group = new ToggleGroup();

		RadioButton button1 = new RadioButton("4");
		button1.setToggleGroup(group);
		button1.setOnAction( e -> {
			NbreParLigne = 4;
			s.play();
		});

		RadioButton button2 = new RadioButton("12");
		button2.setToggleGroup(group);
		button2.setOnAction( e -> {
			NbreParLigne = 12;
			s.play();
		});

		RadioButton button3 = new RadioButton("24");
		button3.setToggleGroup(group);
		button3.setOnAction( e -> {
			NbreParLigne = 24;
			s.play();
		});

		RadioButton button4 = new RadioButton("30");
		button4.setToggleGroup(group);
		button4.setOnAction( e -> {
			NbreParLigne = 30;
			s.play();
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

		Text text = new Text(390,490,"Score : " + p);
		text.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		text.setFill(Color.BLACK);

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
			s.play();
			Node source = (Node) e.getSource();
			Stage window = (Stage) source.getScene().getWindow();
			window.setScene(new Scene(createContent1()));
		});
		menuu.setOnAction(e -> {
			s.play();
			menu.Menu.main(null);
		});

		quit.setOnAction(e -> {
			s.play();
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
			s.play();
			Alert dialog = new Alert(AlertType.INFORMATION);
			dialog.setTitle("Jeu Memory");
			dialog.setContentText("Vous allez etre redirigé vers les scores");
			dialog.showAndWait();
		});

		Image im1 = new Image("chaton.jpg",100,100,false,false);
		Image im2 = new Image("chiot.jpg",100,100,false,false);
		Image im3 = new Image("lapin.jpg",100,100,false,false);
		Image im4 = new Image("chevre.jpg",100,100,false,false);
		Image im5 = new Image("phoque.jpg",100,100,false,false);
		Image im6 = new Image("giraffe.jpeg",100,100,false,false);
		Image im7 = new Image("singe.jpeg",100,100,false,false);
		Image im8 = new Image("renard.jpeg",100,100,false,false);
		Image im9 = new Image("tigre.jpeg",100,100,false,false);
		Image im10 = new Image("elephant.jpeg",100,100,false,false);
		Image im11 = new Image("ecureuil.jpeg",100,100,false,false);
		Image im12 = new Image("lion.jpg",100,100,false,false);

		Image images[] = {im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11,im12};

		ArrayList<Carte> cartes = new ArrayList<>();
		for (int i=0; i<NbreParLigne; i++) {
			if (NbreParLigne == 4) {
				cartes.add(new Carte(images[i]));
				cartes.add(new Carte(images[i]));
			}
			else {
				cartes.add(new Carte(images[i]));
				cartes.add(new Carte(images[i]));
				cartes.add(new Carte(images[i]));
			}
		}
		Collections.shuffle(cartes); //melanger les images

		for (int i = 0; i < cartes.size(); i++) {
			Carte c = cartes.get(i);
			c.setTranslateX(100 * (i % NbreParLigne));
			c.setTranslateY(100 * (i / NbreParLigne));
			root.getChildren().add(c);
		} //afficher les images

		root.getChildren().addAll(quit,score,menuu,retour,text);

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

			Rectangle bord = new Rectangle(100,100);
			bord.setFill(Color.TEAL);
			bord.setStroke(Color.BLACK);

			iw.setImage(img);

			setAlignment(Pos.CENTER);
			getChildren().addAll(bord, iw);

			setOnMouseClicked(event -> { //retourner la carte lors du click
				Sound s = new Sound("resources/Card-flip-sound-effect.mp3");
				s.play();
				if (carteRetournee() || NbreClicks == 0 )
					return;
				NbreClicks --;

				if (CarteSelectionnee == null) {
					CarteSelectionnee = this;  //la carte selectionnee n'est plus egale a null
					retournerCarte(()-> {}); //ne fait rien

				}

				else {
					retournerCarte(() -> {
						if (!memeCarte(CarteSelectionnee)) {
							CarteSelectionnee.faceCachee();
							this.faceCachee();
							pointsNegatifs();
						}
						CarteSelectionnee = null; //re initialiser la carte
						NbreClicks = 2;
					});
				}
				System.out.println("p" + p);
			});
			faceCachee();
		}
		


		public boolean carteRetournee() { //si opacite=1 return true donc la carte est retournee
			return iw.getOpacity()==1;
		}
		public void retournerCarte(Runnable action) {
			FadeTransition t = new FadeTransition(Duration.seconds(0.2), iw);
			t.setToValue(1); //Montrer l'image opacite=1
			t.setOnFinished(e -> action.run()); //action executee quand la carte a ete retournee 
			t.play();
		}

		public void faceCachee() {
			FadeTransition t = new FadeTransition(Duration.seconds(0.2), iw);
			t.setToValue(0); //cacher l'image opacite=0
			t.play();
		}

		public boolean memeCarte(Carte to) {
			return iw.getImage().equals(to.iw.getImage()); //comparer les deux cartes
		}

		public int pointsNegatifs() {
			return p--;
		}

		
	}


	public static void main(String[] args) {
		launch(args);
	}
}