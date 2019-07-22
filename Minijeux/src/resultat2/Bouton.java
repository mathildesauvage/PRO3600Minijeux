package resultat2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Bouton {
	
	
	
	
	
	public static void boutonMenu(Stage stage, MenuItem item) {
		item.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			    menu.Main.main(null);
			}
		});
	}
	
	
	
	
	
	public static void boutonPlay(Stage stage, MenuItem itemMemory, MenuItem itemRunner) {
		itemMemory.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.close();
				memory.Jeu.main(null);
			}
		});
		itemRunner.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.close();
			    runner.Main.main(null);
			}
		});
	}
	
	
	
	
	
	public static void boutonScores(Stage stage, MenuItem itemMemory, MenuItem itemRunner) {
		itemMemory.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				
			}
		});
		itemRunner.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				actualisationScores.actualisation();
				/*JFrame fenetre = new JFrame();
			    fenetre.setVisible(true);
			    fenetre.setTitle("Tableau score runner");
			    fenetre.setSize(400, 150);
			    fenetre.setLocationRelativeTo(null);
			    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    fenetre.setContentPane(new Panneau());
			    fenetre.setVisible(true);*/
			}
		});
	}
	
}