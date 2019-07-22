package memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;


import javafx.animation.Animation.Status;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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


public class Jeu extends Application {

	Label GameOver;
	Label label;
	int score;
	Label lb;
	private int NbreParLigne;
	private int NbreDePairs;
	private int NbCartesRetournées;
	private Carte CarteSelectionnee = null;
	private int NbreClicks = 2;
	ToggleGroup group = new ToggleGroup();
	Sound s = new Sound("resources/toggle.mp3");
	Sound intro = new Sound("resources/Queen.mp3");

	//CHRONO

	private final Integer starttime = 0;
	private Integer seconds = starttime;
	KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			seconds++;
			lb.setText("Temps : " + seconds.toString());
			if (seconds > 99) {
				time.stop();
				GameOver.setVisible(true);
			}
		}
	});
	Timeline time = new Timeline(frame);

	private Parent Accueil() {
		Pane root = new Pane();
		root.setPrefSize(800, 600);	
		
		time.setCycleCount(Timeline.INDEFINITE);

		LinearGradient lg = new LinearGradient(0,0,0,1,true,CycleMethod.NO_CYCLE,new Stop(0.3f,Color.LAVENDER),new Stop(0.75f,Color.PLUM));
		root.setBackground(new Background(new BackgroundFill(lg, CornerRadii.EMPTY, Insets.EMPTY)));

		Text text = new Text(250,200,"Jeu Memory");
		text.setFont(Font.font("Helvetica", FontWeight.BOLD, 50));
		text.setStroke(Color.TURQUOISE);
		text.setFill(Color.BLACK);

		Text text2 = new Text(250,240,"Choisissez le nombre de cartes : ");
		text2.setFont(Font.font("Helvetica", FontWeight.NORMAL, 20));

		Image on = new Image("on.png",50,50,false,false);
		Image off = new Image("off.png",50,50,false,false);
		ImageView iwOn = new ImageView(on);
		ImageView iwOff = new ImageView(off);
		iwOn.setVisible(false);

		iwOn.setOnMouseClicked(e -> {
			iwOn.setVisible(false);
			iwOff.setVisible(true);
			intro.stop();
		});

		iwOff.setOnMouseClicked(e -> {
			iwOff.setVisible(false);
			iwOn.setVisible(true);
			intro.playNonStop();
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
			if (time.getStatus() == Status.STOPPED || time.getStatus() == Status.PAUSED  ) {
				time.playFromStart();
			}
			seconds = 0;
			s.play();
			Node source = (Node) e.getSource();
			Stage window = (Stage) source.getScene().getWindow();
			window.setScene(new Scene(leJeu()));
		});

		retour.setOnAction(e -> {
			s.play();
			menu.Main.main(null);
			Node source = (Node) e.getSource();
			Stage window = (Stage) source.getScene().getWindow();
			window.setScene(new Scene(leJeu()));
			window.close();
		});

		ToggleGroup group = new ToggleGroup();

		RadioButton button1 = new RadioButton("8");
		button1.setToggleGroup(group);
		button1.setOnAction( e -> {
			NbreDePairs = 4;
			NbreParLigne = 4;
			s.play();
		});

		RadioButton button2 = new RadioButton("10");
		button2.setToggleGroup(group);
		button2.setOnAction( e -> {
			NbreDePairs = 5;
			NbreParLigne = 5;
			s.play();
		});

		RadioButton button3 = new RadioButton("14");
		button3.setToggleGroup(group);
		button3.setOnAction( e -> {
			NbreDePairs = 7;
			NbreParLigne = 7;
			s.play();
		});

		RadioButton button4 = new RadioButton("24");
		button4.setToggleGroup(group);
		button4.setOnAction( e -> {
			NbreDePairs = 12;
			NbreParLigne = 8;
			s.play();
		});

		VBox menuButtons = new VBox(5);
		menuButtons.getChildren().addAll(button1,button2,button3,button4);

		root.getChildren().addAll(text,menuButtons,text2,start,retour,iwOn,iwOff);

		menuButtons.setLayoutX(350);
		menuButtons.setLayoutY(260);

		return root;
	}

	private Parent leJeu() {
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

		lb= new Label("Temps : " + seconds.toString());
		lb.setLayoutX(350);
		lb.setLayoutY(450);
		lb.setFont(Font.font(30));

		//BOUTONS

		Button rejouer = new Button("Rejouer");
		Button menuu = new Button("Menu");
		Button quit = new Button("Quitter");
		Button score = new Button("Score");
		Button retour = new Button("Retour");

		rejouer.setLayoutX(50);
		rejouer.setLayoutY(500);
		retour.setLayoutX(200);
		retour.setLayoutY(500);
		menuu.setLayoutX(350);
		menuu.setLayoutY(500);
		quit.setLayoutX(500);
		quit.setLayoutY(500);
		score.setLayoutX(650);
		score.setLayoutY(500);

		rejouer.setPrefSize(100, 50);
		menuu.setPrefSize(100, 50);
		quit.setPrefSize(100, 50);
		score.setPrefSize(100, 50);
		retour.setPrefSize(100, 50);


		rejouer.setOnAction(e -> {
			if (time.getStatus() == Status.RUNNING) {
				time.stop();
			}
			s.play();
			Alert dialogC = new Alert(AlertType.CONFIRMATION);
			dialogC.setTitle("Jeu Memory");
			dialogC.setHeaderText(null);
			dialogC.setContentText("Voulez-vous rejouer ?");
			Optional<ButtonType> answer = dialogC.showAndWait();
			if (answer.get() == ButtonType.OK) {
				Node source = (Node) e.getSource();
				Stage window = (Stage) source.getScene().getWindow();
				window.setScene(new Scene(leJeu()));
				seconds = 0;
				time.playFromStart();

			}
			else {
				time.play();
			}
		});

		retour.setOnAction(e -> {
			if (time.getStatus() == Status.RUNNING) {
				time.stop();
			}
			s.play();
			Node source = (Node) e.getSource();
			Stage window = (Stage) source.getScene().getWindow();
			window.setScene(new Scene(Accueil()));
		});

		menuu.setOnAction(e -> {
			if (time.getStatus() == Status.RUNNING) {
				time.stop();
			}

			s.play();
			menu.Main.main(null);
			Node source = (Node) e.getSource();
			Stage window = (Stage) source.getScene().getWindow();
			window.setScene(new Scene(leJeu()));
			window.close();
		});

		quit.setOnAction(e -> {
			if (time.getStatus() == Status.RUNNING) {
				time.stop();
			}

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
			
			Node source = (Node) e.getSource();
			Stage window = (Stage) source.getScene().getWindow();
			window.setScene(new Scene(leJeu()));
			window.close();
			resultat2.Main.main(null);
		});

		//MISE EN PLACE DES IMAGES

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
		for (int i=0; i<NbreDePairs; i++) {
			cartes.add(new Carte(images[i]));
			cartes.add(new Carte(images[i]));
		}

		Collections.shuffle(cartes); //melanger les images

		for (int i = 0; i < cartes.size(); i++) {
			Carte c = cartes.get(i);
			c.setTranslateX(100 * (i % NbreParLigne));
			c.setTranslateY(100 * (i / NbreParLigne));
			root.getChildren().add(c);
		} //afficher les images

		root.getChildren().addAll(quit,score,menuu,retour,rejouer,lb,label,GameOver);
		return root;

	}

	@Override
	public void start(Stage Pstage) throws Exception{
		Pstage.setTitle("Jeu Memory");
		intro.play();
		Pstage.setScene(new Scene(Accueil()));
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
						}
						else {
							NbCartesRetournées ++;
						}
						CarteSelectionnee = null; //re initialiser la carte
						NbreClicks = 2;
						if (NbCartesRetournées == NbreDePairs ) {
							NbCartesRetournées = 0;
							time.stop();
							score = seconds;
							label.setVisible(true);
						}
					});
				}

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

	}

	public static void main(String[] args) {
		launch(args);
	}

}