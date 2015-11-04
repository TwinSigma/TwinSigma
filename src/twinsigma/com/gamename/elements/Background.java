package twinsigma.com.gamename.elements;

import java.awt.image.BufferedImage;

import twinsigma.com.gamename.graphic.gui.Window;

public class Background extends SceneElement{

	public Background(double x, double y, BufferedImage img) {
		super(x, y, img);
	}
	
	public void centerOnElement(SceneElement e){
		this.setLocation(e.x + e.width/2 - Window.WIDTH/2, e.y + e.height/2 - Window.HEIGHT/2);
	}

}
