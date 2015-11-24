package twinsigma.com.gamename.graphic;

import java.awt.image.BufferedImage;

public class Sprite {
	
	private BufferedImage[] imgs;
	private final boolean animated;
	private final int fps;
	
	private int currentFrame;
	
	public Sprite(int fps, BufferedImage... img){
		imgs = img;
		animated = imgs.length > 1;
		currentFrame = 0;
		this.fps = fps;
	}
	
	public int getWidth(){
		return this.getCurrentFrame().getWidth();
	}
	
	public int getHeight(){
		return this.getCurrentFrame().getHeight();
	}
	
	public boolean isAnimated(){
		return animated;
	}
	
	public BufferedImage gotoFrame(int frame){
		currentFrame = frame;
		if(currentFrame > imgs.length){
			currentFrame = 0;
		}else if(currentFrame < 0){
			currentFrame = imgs.length-1;
		}
		return imgs[currentFrame];
	}
	
	public BufferedImage nextFrame(){
		currentFrame++;
		return gotoFrame(currentFrame);
	}
	
	public BufferedImage getCurrentFrame(){
		return imgs[currentFrame];
	}

}
