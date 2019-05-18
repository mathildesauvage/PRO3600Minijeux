package runner;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Objet {
	Image image;
	double largeur;
	double hauteur;
	double x;
	double y;
	double xSpeed;
	double ySpeed;
	int points;
	
	Objet(String name, double largeur, double hauteur,int points) {
		this.image = new Image(name,largeur, hauteur, false, false);
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.points = points;
	}
	
	public void setPosition(double x, double y){
		this.x=x;
		this.y=y;
	}
	public void setSpeed(double xSpeed, double ySpeed) {
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	public void render(GraphicsContext gc) {
		gc.drawImage(this.image,x,y);
	}

	public boolean estAuBord(Papillon papi) {
		if (x == -papi.largeur-1) {
			return true;
		} else {
			return false;
		}
	}
}
