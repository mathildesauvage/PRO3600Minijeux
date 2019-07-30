package allInOne;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//classes : Resultat (=fenêtre), ResultatBouton, BarSup, AffichageScores

public class Resultat {
	
	public void setStage() {
		Main.stage.setTitle("SCORES");
        Main.root = new Group();
        Main.scene = new Scene(Main.root, 200, 328, Color.WHITE);
		
	    BarSup barsup = new BarSup(Main.stage);
        Image fond = new Image("/scores/podium.jpg", 200, 328, false, false);
        ImageView image = new ImageView(fond);
        
		Main.root.getChildren().setAll(image);
		Main.root.getChildren().add(barsup);
        
        Main.stage.setResizable(false);
        Main.stage.setScene(Main.scene);
		Main.stage.show();
	}
}



class BarSup extends BorderPane {
	
	public BarSup(Stage stage) {
		
		MenuBar menuBar = new MenuBar();
		
		//Options Memory
        Menu memoryMenu = new Menu("Memory");
        MenuItem openScoresMemoryItem = new MenuItem("Scores");
        MenuItem playMemoryItem = new MenuItem("Jouer");
        memoryMenu.getItems().addAll(openScoresMemoryItem, playMemoryItem);
        //Options Runner
        Menu runnerMenu = new Menu("Runner");
        MenuItem openScoresRunnerItem = new MenuItem("Scores");
        MenuItem playRunnerItem = new MenuItem("Jouer");
        runnerMenu.getItems().addAll(openScoresRunnerItem, playRunnerItem);
        //options Quitter
        Menu quitMenu = new Menu("Quit");
        MenuItem quitScoresItem = new MenuItem("Retour menu");
        quitMenu.getItems().add(quitScoresItem);
        menuBar.getMenus().addAll(memoryMenu, runnerMenu, quitMenu);
        
        ResultatBouton.boutonMenu(stage, quitScoresItem);
        ResultatBouton.boutonPlay(stage, playMemoryItem, playRunnerItem);
        ResultatBouton.boutonScores(stage, memoryMenu, runnerMenu);
        
        this.setTop(menuBar);
		
	}

}

class ResultatBouton {
	public static void boutonMenu(Stage stage, MenuItem item) {
		item.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.close();
			    //Main.main(null);
			}
		});
	}
	public static void boutonPlay(Stage stage, MenuItem itemMemory, MenuItem itemRunner) {
		itemMemory.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//TODO
			}
		});
		itemRunner.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//TODO
			}
		});
	}
	public static void boutonScores(Stage stage, MenuItem itemMemory, MenuItem itemRunner) {
		itemMemory.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				AffichageScores aff = new AffichageScores("memory");
		        Main.root.getChildren().add(aff);
			}
		});
		itemRunner.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				AffichageScores aff = new AffichageScores("runner");
		        Main.root.getChildren().add(aff);
			}
		});
	}
}

class AffichageScores extends Parent {
	
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
