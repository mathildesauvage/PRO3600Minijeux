package resultat2;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AffichageScores extends Parent {
	
	public AffichageScores() {
		int i = 0;
		while (i < 5) {
			if (i <3) {
				Rectangle rect = new Rectangle();
				rect.setWidth(200);
		        rect.setHeight(60);
		        rect.setLayoutY(30+i*120);
		        rect.setFill(Color.LIGHTBLUE);
		        this.getChildren().add(rect);
			} 
			Text text = new Text("Player "+(i+1));
	        text.setFont(new Font(12));
			text.setFill(Color.BLACK);
			text.setX(5);
			text.setY(61+i*60);
			this.getChildren().add(text);
			
			Text score = new Text("Score "+(i+1));
			score.setFont(new Font(12));
			score.setFill(Color.BLACK);
			score.setX(145);
			score.setY(61+i*60);
			this.getChildren().add(score);
			
	        i += 1;
		}
		
		
		
		
	}

}
