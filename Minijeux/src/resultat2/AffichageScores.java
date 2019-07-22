package resultat2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AffichageScores extends Parent {
	
	public AffichageScores(String jeu) {
		int i = 0;
		String[] tab = new String[5];
		try{
			InputStream flux=new FileInputStream("resources/scores/scoreRunner.txt"); 
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			while ((ligne=buff.readLine())!=null) {
				tab[i] = ligne;
				i += 1;
			}
			buff.close(); 
			}		
			catch (Exception e) {
				System.out.println(e.toString());
			}
		
		i = 0;
		while (i < 5) {
			Rectangle rect = new Rectangle();
			rect.setWidth(200);
	        rect.setHeight(60);
	        rect.setLayoutY(28+i*60);
			if (i%2 == 0) { //0, 2, 4
		        if (jeu == "runner") {
		        	rect.setFill(Color.LIGHTPINK);
		        } else {
		        	rect.setFill(Color.LIGHTBLUE);
		        }
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
