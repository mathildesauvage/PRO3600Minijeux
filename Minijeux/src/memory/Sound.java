package memory;

import java.io.File;

import javafx.scene.media.AudioClip;


public class Sound {

	String file;
	AudioClip sound;

	public Sound(String file) {
		this.file = file;
		this.sound = new AudioClip(new File(file).toURI().toString());
	}

	public void play(){
		sound.play();
	}

	public void stop(){
		sound.stop();
	}
	
	public void playNonStop() {
		sound.setCycleCount(AudioClip.INDEFINITE);
		sound.play();
	}

}
