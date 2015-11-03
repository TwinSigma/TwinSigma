package twinsigma.com.gamename.graphic.gui;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Gui {
	
	public int x,y,width,height;
	
	public Gui(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, width, height);
	}
	
	public void onType(int c){}
	
	public void onUnType(int c){}
	
	public abstract void draw(Graphics2D g2d);

}
