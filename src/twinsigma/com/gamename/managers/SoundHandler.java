package twinsigma.com.gamename.managers;

import java.net.URL;
import java.util.ArrayList;
import javafx.scene.media.Media;
import twinsigma.com.gamename.sound.Sound;

public class SoundHandler {
	
	public static final String path = "/twinsigma/com/resources/sounds/";
	
	private static ArrayList<Sound> cache = new ArrayList<Sound>();
	
	public SoundHandler(){
		Thread cacheHandler = new Thread(){
			@Override
			public void run(){
				handleCache();
			}
		};
	}
	
	/**
	 * Play a sound once
	 * @param name "object/sound(# for variation)"
	 */
	public static void playSound(String name){
		for(Sound s : cache){
			if(s.name.equals(name)){
				s.playSound();
				return;
			}
		}
		URL url = SoundHandler.class.getResource(path + name + ".mp3");
		Media media = new Media(url.getFile());
		Sound sound = new Sound(name, media);
		cache.add(sound);
		sound.playSound();
	}
	
	private void handleCache(){
		while(true){
			for(Sound s : cache){
				if(!s.isPlaying() && s.liveTime > 300){
					cache.remove(s);
					continue;
				}
				s.liveTime++;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
