package twinsigma.com.gamename.elements;

import java.awt.image.BufferedImage;

public class SceneElement {
	
	public double x,y;
	public double width,height;
	public double rotation;
	public double xMotion,yMotion;
	
	public BufferedImage img;
	
	public SceneElement(double x, double y, double width, double height, double rotation, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.rotation = rotation;
		this.img = img;
	}
	
	public SceneElement(double x, double y, BufferedImage img){
		this(x,y,img.getWidth(),img.getHeight(),0,img);
	}
	
	public void changeImage(BufferedImage img){
		this.img = img;
	}
	
	public void setLocation(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public void setMotion(double x, double y){
		this.xMotion = x;
		this.yMotion = y;
	}

}
