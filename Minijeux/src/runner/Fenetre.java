package runner;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Fenetre {
	double largeur;
	double hauteur;
	public static int score;
	int level;
	Image fond;
	Bouton quit;
	Bouton scores;
	Group group;
	Scene scene;
	Stage stage;
	
	Fenetre(double largeur, double hauteur, int score, int level, Group g, Scene scene, Stage stage, String name) { //constructeur
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.score = score;
		this.level = level;
		this.group = g;
		this.scene = scene;
		this.stage = stage;
		fond = new Image(name,largeur,hauteur,false,false);
	}
	
	
	public void setInterface(GraphicsContext gc) { //met en place l'interface graphique
		gc.drawImage(fond, 0, 0);
		gc.setFont(Font.font("Helvetica", FontWeight.BOLD, 24));
	    gc.setFill(Color.TURQUOISE);
	    gc.setStroke(Color.BLUE);
	    gc.setLineWidth(1);
        gc.fillText("Score: "+score, 480, 36);
        gc.strokeText("Score: "+score, 480,36);
        gc.fillText("Level: "+level, 20, 36);
	    gc.strokeText("Level: "+level, 20, 36);
	}
	
	public void setBouton() { //met en place les boutons quit et scores
		Bouton quit = new Bouton("Quit", Color.WHITE, Color.TURQUOISE, 85, 50, 25, 450);
	    quit.setBouton(group, 40, 480, "Helvetica", FontWeight.BOLD, 24);
	    quit.setInteractionSouris(scene, stage, this, "quit");
	    
	    Bouton scores = new Bouton("Scores", Color.WHITE, Color.TURQUOISE, 100, 50, 510, 450);
	    scores.setBouton(group, 515, 480, "Helvectica", FontWeight.BOLD, 24);
	    scores.setInteractionSouris(scene, stage, this, "scores");
	}
}