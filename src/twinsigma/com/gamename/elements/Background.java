package twinsigma.com.gamename.elements;

import twinsigma.com.gamename.graphic.Sprite;
import twinsigma.com.gamename.graphic.gui.Window;

public class Background extends MovableElement{

	public Background(double x, double y, Sprite img) {
		super(x, y, img);
	}
	
	public void centerOnElement(MovableElement e){
		this.setLocation(e.x + e.width/2 - Window.WIDTH/2, e.y + e.height/2 - Window.HEIGHT/2);
	}

}
