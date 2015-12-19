package twinsigma.com.gamename.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound{
	
	public final String name;
	public final Media sound;
	
	public int liveTime;
	private boolean isPlaying;
	
	private MediaPlayer player;
	
	public Sound(String name, Media sound){
		this.name = name;
		this.sound = sound;
		player = new MediaPlayer(sound);
	}
	
	public void playSound(){
		isPlaying = true;
		player.play();
	}
	
	public void stopSound(){
		isPlaying = false;
		player.stop();
	}
	
	public boolean isPlaying(){
		return this.isPlaying;
	}
	
}
