package resultat2;
	import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
	 
	public class Main extends Application {
		
		public static void main(String[] args) {
	        Application.launch(args);
	    }
		
	    public void start(Stage stage) {
	    	menu.Main.root = new Group();
	        menu.Main.scene = new Scene(menu.Main.root, 200, 330, Color.WHITE);
	        
	        
	        
	        AffichageScores aff = new AffichageScores();
	        menu.Main.root.getChildren().add(aff);
	        
	        BarSup barsup = new BarSup(stage);
	        menu.Main.root.getChildren().add(barsup);
	        
	        stage.setTitle("SCORES");
	        stage.setResizable(false);
	        stage.setScene(menu.Main.scene);
	        stage.show();
	        
	        
	    }
	 
	}
