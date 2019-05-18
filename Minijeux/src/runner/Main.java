package runner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


public class Main extends Application {
	int score = 0;
	int level = 1;
	int level_max = 3;
	int nbObjet_max = 5;
	int compteur = 0;
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage stage) {
		stage.setTitle("Runner butterflies");
		Group group = new Group();
		Scene scene = new Scene(group);
	    stage.setScene(scene);
	    Canvas canevas = new Canvas(640, 540);
	    group.getChildren().add(canevas);
	    stage.setResizable(false);
	    GraphicsContext gc = canevas.getGraphicsContext2D();
	    
	    //papillon
	    Papillon papi = new Papillon("butterflies.png",33,40);
	    papi.setPosition(0,300);
	    papi.setSpeed(0,35);
	    papi.render(gc);
	    
	    //obstacles
	    Objet[] tab = new Objet[1];
	    tab[0]=Papillon.createObjet(level);
	    
	    
	    //mise en place de l'animation
	    AnimationTimer animation = new AnimationTimer() {
	    	public void handle (long now){
	    		Fenetre fenetre = null;
	    		fenetre = new Fenetre(640,540, score, level, group, scene, "prairie.jpg");
	    		fenetre.setInterface(gc);
	    		fenetre.setBouton();
	    		
	    		tab[0].x+=tab[0].xSpeed;
			    
			    if (tab[0].estAuBord(papi) || papi.intersecte(tab[0])) { //2 conditions pour changer d'objet
			    	if (papi.intersecte(tab[0])) {
			    		score += tab[0].points;
			    		if (score <= 0) {
			    			Papillon.gameOver(fenetre, score, stage);
			    			score = 0;
			    			level = 1;
			    		}
			    	}
			    	compteur += 1; //nbr d'obstacles deja passés
			    	if (compteur >= nbObjet_max) {//s'il faut changer de niveau
			    		compteur=0;
			    		level+=1;
			    		if (level > level_max+1) {
			    			Papillon.gameOver(fenetre, score, stage);
			    			score = 0;
			    			level = 1;
			    		}
			    	}
			    	tab[0]=Papillon.createObjet(level); //on change d'objet après avoir changé de niveau
			    } else {
			    	tab[0].render(gc);
			    }
			    
			    papi.render(gc);
			    papi.controleClavier(papi, gc, scene);
			    
    		}; //fin du handle		
	    };//fin de l'animation
	    
	    	animation.start();
	        stage.show();
	       
	}//fin du start
}//fin de la class 