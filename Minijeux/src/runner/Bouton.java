package runner;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Bouton {
	String text;
	Color color_fond;
	Color color_text;
	double largeur;
	double hauteur;
	double x;
	double y;
	Rectangle fond;
	
	Bouton(String text, Color color_fond, Color color_text, double largeur, double hauteur, double x, double y){
		this.text = text;
		this.color_fond = color_fond;
		this.color_text = color_text;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.x = x;
		this.y = y;
	}
	
	public void setBouton(Group g, double posX_text, double posY_text, String police, FontWeight fw, double weight) {
		fond = new Rectangle(largeur,hauteur,color_fond);
	    fond.setX(x);
	    fond.setY(y);
	    g.getChildren().add(fond);
	    Text txt = new Text();
	    txt.setText(text);
	    txt.setX(posX_text);
	    txt.setY(posY_text);
	    txt.setFont(Font.font(police, fw, weight));
	    txt.setFill(color_text);
	    g.getChildren().add(txt);
	}
	
	public void setInteractionSouris(Scene scene, Stage stage,  Fenetre fenetre, String type) {
		fond.setOnMousePressed(new EventHandler<MouseEvent>(){
			public void handle (MouseEvent me) {
				if (type=="quit") {
					stage.close();
				} else if (type=="scores") {
					resultat2.Main.main(null);
					stage.close();
				}
			};//fin du handle
		});//fin du event
	}

}
