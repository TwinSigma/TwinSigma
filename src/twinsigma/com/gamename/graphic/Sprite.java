package twinsigma.com.gamename.graphic;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Sprite {
	
	private BufferedImage[] frames;
	private final boolean animated;
	private final int fps;
	
	private int runTime;
	
	private int currentFrame;
	
	public Sprite(int fps, BufferedImage... img){
		frames = img;
		animated = frames.length > 1;
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
		if(currentFrame >= frames.length){
			currentFrame = 0;
		}else if(currentFrame < 0){
			currentFrame = frames.length-1;
		}
		return frames[currentFrame];
	}
	
	public BufferedImage nextFrame(){
		currentFrame++;
		return gotoFrame(currentFrame);
	}
	
	public BufferedImage getCurrentFrame(){
		return frames[currentFrame];
	}
	
	public void render(Graphics2D g2d, double x, double y, double width, double height, double rot){
		AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(rot), width/2, height/2);
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		if(animated){
			g2d.drawImage(op.filter(this.getCurrentFrame(), null), (int) x, (int) y, (int) width, (int) height, null);
			runTime++;
			if(runTime == 60/fps){
				runTime = 0;
				this.nextFrame();
			}
		}else{
			g2d.drawImage(op.filter(this.frames[0], null), (int) x, (int) y, (int) width, (int) height, null);
		}
	}

}
