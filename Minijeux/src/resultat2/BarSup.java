package resultat2;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BarSup extends BorderPane {
	
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
        
        Bouton.boutonMenu(stage, quitScoresItem);
        Bouton.boutonPlay(stage, playMemoryItem, playRunnerItem);
        Bouton.boutonScores(stage, memoryMenu, runnerMenu);
        
        this.setTop(menuBar);
		
	}

}
