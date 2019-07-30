package memory;

import java.time.Duration;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Carte extends StackPane {
	private ImageView iw = new ImageView();

	public Carte(Image img) {
		Rectangle bord = new Rectangle(100,100);
		bord.setFill(Color.TEAL);
		bord.setStroke(Color.BLACK);

		iw.setImage(img);

		setAlignment(Pos.CENTER);
		getChildren().addAll(bord, iw);

		setOnMouseClicked(event -> { //retourner la carte lors du click
			Sound s = new Sound("resources/memory/Card-flip-sound-effect.mp3");
			s.play();
			if (carteRetournee() || Main.NbreClicks == 0 )
				return;
			Main.NbreClicks --;

			if (Main.CarteSelectionnee == null) {
				Main.CarteSelectionnee = this;  //la carte selectionnee n'est plus egale a null
				retournerCarte(()-> {}); //ne fait rien

			}

			else {
				retournerCarte(() -> {
					if (!memeCarte(Main.CarteSelectionnee)) {
						Main.CarteSelectionnee.faceCachee();
						this.faceCachee();
					}
					else {
						Main.NbCartesRetournées ++;
					}
					Main.CarteSelectionnee = null; //re initialiser la carte
					Main.NbreClicks = 2;
					if (Main.NbCartesRetournées == Main.NbreDePairs ) {
						Main.NbCartesRetournées = 0;
						Main.time.stop();
						Main.score = Main.seconds;
						Main.label.setVisible(true);
					}
				});
			}

		});
		faceCachee();

	}



	public boolean carteRetournee() { //si opacite=1 return true donc la carte est retournee
		return iw.getOpacity()==1;
	}
	public void retournerCarte(Runnable action) {
		FadeTransition t = new FadeTransition();
		t.setDuration(Duration.ZERO);
		t.setNode(iw);
		t.setToValue(1); //Montrer l'image opacite=1
		t.setOnFinished(e -> action.run()); //action executee quand la carte a ete retournee 
		t.play();
	}

	public void faceCachee() {
		FadeTransition t = new FadeTransition();
		t.setDuration(Duration.seconds(0.2));
		t.setNode(iw);
		t.setToValue(0); //cacher l'image opacite=0
		t.play();
	}

	public boolean memeCarte(Carte to) {
		return iw.getImage().equals(to.iw.getImage()); //comparer les deux cartes
	}

}