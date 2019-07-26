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
				memory.Main.main(null);
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
				AffichageScores aff = new AffichageScores("memory");
		        menu.Main.root.getChildren().add(aff);
			}
		});
		itemRunner.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				AffichageScores aff = new AffichageScores("runner");
		        menu.Main.root.getChildren().add(aff);
			}
		});
	}
	
}