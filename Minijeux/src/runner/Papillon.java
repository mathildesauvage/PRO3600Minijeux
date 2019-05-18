package runner;

import javax.swing.JOptionPane;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Papillon {
	Image image;
	double largeur;
	double hauteur;
	double x;
	double y;
	double xSpeed;
	double ySpeed;
	
	Papillon(String name, double largeur, double hauteur) {
		this.image = new Image(name,largeur, hauteur, false, false);
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void setSpeed(double xSpeed, double ySpeed) {
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	public void validatePosition(){
		if (largeur + x >= 640) { //le papillon ne peut pas sortir de la fenetre à droite
			x = 0;
		} else if (x<0) { //le papillon ne peut pas sortir de la fenetre à gauche
			x=0;
		}
		if (y > 300) { //le papillon ne peut pas passer sous terre
	    	y = 300;
	    } else if (y < 0) { //le papillon ne peut pas sortir de la fenetre en haut
	    	y = 0;
	    }
	}
	
	
	
	
	public static Objet createObjet (int level) {
		Objet obj;
		int vitesse_objets = -3*level;
		double a = Math.random(); //pour que le type de l'obstacle soit aleatoire
    	if (a<0.25) {
    		Tronc tronc = new Tronc();
    		tronc.setPosition(620, 60 + 220*Math.random());
		    tronc.setSpeed(vitesse_objets,0);
		    obj = tronc;
    	} else if (a<0.5) {
    		Boule_de_feu bdf = new Boule_de_feu();
    		bdf.setPosition(620, 60 + 220*Math.random());
		    bdf.setSpeed(vitesse_objets,0);
		    obj = bdf;
    	} else if (a<0.75) {
    		Trefle trefle = new Trefle();
    		trefle.setPosition(620, 60 + 220*Math.random());
		    trefle.setSpeed(vitesse_objets,0);
		    obj = trefle;
    	} else {
    		Coeur coeur = new Coeur();
    		coeur.setPosition(620, 60 + 220*Math.random());
		    coeur.setSpeed(vitesse_objets,0);
		    obj = coeur;
    	}
		return obj;
	}
	
	
	
	
	
	
	public void render(GraphicsContext gc) {
		gc.drawImage(this.image,x,y);
	}
	
	
	public boolean intersecte(Objet o) {
		if (o.y+o.hauteur >=this.y && o.y+o.hauteur <= this.y+this.hauteur && o.x+o.largeur >= this.x && o.x+o.largeur <= this.x+this.largeur){
			return true;
		}
		if (o.y+o.hauteur >=this.y && o.y+o.hauteur <= this.y+this.hauteur && o.x >= this.x && o.x <= this.x+largeur) {
			return true;
		}
		if (o.y >= this.y && o.y <= this.y+this.hauteur && o.x+o.largeur >= this.x && o.x+o.largeur <= this.x+this.largeur) {
			return true;
		}
		if (o.y >= this.y && o.y <= this.y+this.hauteur && o.x >= this.x && o.x <= this.x+largeur) {
			return true;
		}
		return false;
	}
	
	public void controleClavier(Papillon papi, GraphicsContext gc, Scene scene) {
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
	    	public void handle (KeyEvent e) {
	    		switch(e.getCode()) {
			    case UP:    papi.setPosition(x,y-ySpeed) ; break;
			    case DOWN:  papi.setPosition(x,y+ySpeed) ; break;
			    case LEFT: 	papi.setPosition(x-xSpeed,y) ; break;
			    case RIGHT: papi.setPosition(x+xSpeed,y) ; break;
			    default:
			    }
			    papi.validatePosition();
			    papi.render(gc);
	    	}; //fin du handle
	    });//fin du event
	}
	
	public static void gameOver(Fenetre fenetre, int score, Stage stage) {
		
		String message = "GAME OVER \nQue voulez-vous faire ?";
		
		if (score > 0) { //si le joueur est arrivé au bout du jeu, il peut enregistrer son score
			int option1 = JOptionPane.showConfirmDialog(null, "WELL DONE\nVoulez-vous enregistrer votre score ?", "Fin de la partie", JOptionPane.YES_NO_OPTION);
			if (option1 == JOptionPane.YES_OPTION) {
				System.out.println("Score bien enregistré");
				
				//on enregistre le score
				
				message = "Votre score a bien été enregistré.";
				
			}
		}
		
		String options[] = {"Scores", "Menu", "Nouvelle partie"};
		int option2 = JOptionPane.showOptionDialog(null, message, null, JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[2]);
		if (option2 == 0) {
			
			//redirection vers la page de score
			System.exit(0);
		} else if (option2 == 1) {
			
			//redirection vers le menu
			menu.Menu.main(options); //on lance le menu
			stage.close(); //on ferme la fenetre pour pas les accumuler
		}
	}
}