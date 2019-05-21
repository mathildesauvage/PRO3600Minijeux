package memory;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {

	String file;
	Media sound;
	MediaPlayer player;

	public Sound(String file) {
		this.file = file;
		this.sound = new Media(new File(file).toURI().toString());
		this.player = new MediaPlayer(sound);
	}

	public void play(){
		player.play();
	}

	public void stop(){
		player.stop();
	}

}
