package allInOne;

import java.io.File;
import javafx.scene.media.AudioClip;

public class Sound {

	String file;
	AudioClip audio_sound;

	public Sound(String file) {
		this.file = file;
		this.audio_sound = new AudioClip(new File(file).toURI().toString());
	}

	public void play(){
		audio_sound.play();
	}

	public void stop(){
		audio_sound.stop();
	}
	
	public void playNonStop() {
		audio_sound.setCycleCount(AudioClip.INDEFINITE);
		audio_sound.play();
	}

}
