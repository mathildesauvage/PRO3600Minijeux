package resultat2;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AffichageScores extends Parent {
	
	public AffichageScores(String jeu) {
		int i = 0;
		String[] tab = new String[5];
		Color color;
		
		if (jeu == "memory") {
        	color = Color.LIGHTPINK;
        	for (String elt : memory.ActualisationScores.tabMemory) {
        		tab[i] = elt;
        		i += 1 ;
        	}
        } else {
        	color = Color.LIGHTBLUE;
        	for (String elt : runner.ActualisationScores.tabRunner) {
        		tab[i] = elt;
        		i += 1 ;
        	}
        }
		
		i = 0;
		while (i < 5) {
			Rectangle rect = new Rectangle();
			rect.setWidth(200);
	        rect.setHeight(60);
	        rect.setLayoutY(28+i*60);
			if (i%2 == 0) { //0, 2, 4
		        rect.setFill(color);
			} else { //1, 3
		        rect.setFill(Color.LIGHTGREY);
			}
			this.getChildren().add(rect);
			
			Text text = new Text("Player "+(i+1));
	        text.setFont(new Font(12));
			text.setFill(Color.BLACK);
			text.setX(5);
			text.setY(61+i*60);
			this.getChildren().add(text);
			
			Text affichage = new Text(tab[i]);
			affichage.setFont(new Font(12));
			affichage.setX(145);
			affichage.setY(61+i*60);
			this.getChildren().add(affichage);
	        i += 1;
		}
		
	}

}
