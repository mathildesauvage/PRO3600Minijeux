package resultat2;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AffichageScores extends Parent {
	
	public AffichageScores() {
		int i = 0;
		while (i < 3) {
			Rectangle rect = new Rectangle();
			rect.setWidth(200);
	        rect.setHeight(60);
	        rect.setLayoutY(30+i*120);
	        rect.setFill(Color.ALICEBLUE);
	        this.getChildren().add(rect);
	        i += 1;
		}
	}

}
