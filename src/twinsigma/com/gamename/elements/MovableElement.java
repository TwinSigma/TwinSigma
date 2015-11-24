package twinsigma.com.gamename.elements;

import twinsigma.com.gamename.graphic.Sprite;

public class MovableElement extends SceneElement{
	
	public double xMotion,yMotion;
	
	public MovableElement(double x, double y, double width, double height, double rotation, Sprite sprite) {
		super(x,y,width,height,rotation,sprite);
	}
	
	public MovableElement(double x, double y, Sprite sprite){
		super(x,y,sprite.getWidth(),sprite.getHeight(),0,sprite);
	}
	
	public void update(Scene scene){
		x += xMotion;
		y += yMotion;
		
		xMotion *= .5d;
		yMotion *= .5d;
		if(Math.abs(xMotion) < 0.001d) xMotion = 0;
		if(Math.abs(yMotion) < 0.001d) yMotion = 0;
	}
	
	public void setMotion(double x, double y){
		this.xMotion = x;
		this.yMotion = y;
	}

}
