package twinsigma.com.gamename.elements;

import twinsigma.com.gamename.graphic.Sprite;

public class SceneElement {
	
	public double x,y;
	public double width,height;
	public double rotation;
	
	private Sprite sprite;
	
	public SceneElement(double x, double y, double width, double height, double rotation, Sprite img){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.rotation = rotation;
		this.sprite = img;
	}
	
	public void changeRotation(double rot){
		rotation = rot;
	}
	
	public void changeSprite(Sprite img){
		this.sprite = img;
	}
	
	public void setLocation(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public SceneElement(double x, double y, Sprite img){
		this(x,y,img.getWidth(),img.getHeight(),0,img);
	}
	
	public Sprite getSprite(){
		return this.sprite;
	}
	
	public void screenChange(){}

}
