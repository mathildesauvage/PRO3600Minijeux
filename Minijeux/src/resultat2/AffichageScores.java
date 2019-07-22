package resultat2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AffichageScores extends Parent {
	
	public AffichageScores() {
		int i = 0;
		String[] tab = new String[5];
		try{
			InputStream flux=new FileInputStream("resources/scoreRunner.txt"); 
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
			
			Text affichage = new Text(tab[i]);
			affichage.setFont(new Font(12));
			affichage.setX(145);
			affichage.setY(61+i*60);
			this.getChildren().add(affichage);
	        i += 1;
		}
		
	}

}
