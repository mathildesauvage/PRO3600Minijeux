package menu;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	public static Scene scene;
	public static Group root;
	public static GraphicsContext gc;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
        stage.setTitle("Menu");
        root = new Group();
        scene = new Scene(root, 300, 600, Color.WHITE);
        Canvas canevas = new Canvas(640, 540);
	    root.getChildren().add(canevas);
	    gc = canevas.getGraphicsContext2D();
        
	    
	    
	    
	    
	    
        Bouton memory = new Bouton("Memory", Color.PURPLE, 0, 0);
        Bouton runner = new Bouton("Runner", Color.CORNFLOWERBLUE, 0, 200);
        Bouton scores = new Bouton("Scores", Color.ORANGE, 0, 400);
        
        root.getChildren().add(memory);
        root.getChildren().add(runner);
        root.getChildren().add(scores);
        
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
	
	public void initialiseStage(Stage stage) {
		
	}




}
