package resultat2;
	import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
	 
	public class Main extends Application {
		
		public static void main(String[] args) {
	        Application.launch(args);
	    }
		
	    public void start(Stage stage) {
	    	menu.Main.root = new Group();
	        menu.Main.scene = new Scene(menu.Main.root, 200, 328, Color.WHITE);
	        
	        Image fond = new Image("/scores/podium.jpg", 200, 328, false, false);
	        ImageView image = new ImageView(fond);
	        menu.Main.root.getChildren().setAll(image);
	        
	        
	        BarSup barsup = new BarSup(stage);
	        menu.Main.root.getChildren().add(barsup);
	        
	        stage.setTitle("SCORES");
	        stage.setResizable(false);
	        stage.setScene(menu.Main.scene);
	        stage.show();
	        
	        
	    }
	 
	}
