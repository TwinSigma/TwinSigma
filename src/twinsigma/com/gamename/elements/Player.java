package twinsigma.com.gamename.elements;

import java.awt.event.KeyEvent;

import twinsigma.com.gamename.graphic.Sprite;
import twinsigma.com.gamename.input.Input;

public class Player extends MovableElement{

	public Player(double x, double y, Sprite sprite) {
		super(x, y, sprite);
	}
	
	public Player(double x, double y, double width, double height, double rot, Sprite sprite) {
		super(x, y, width, height, rot, sprite);
	}
	
	public void update(Scene scene){
		this.movement();
		
		super.update(scene);
	}
	
	public void movement(){
		if(Input.isKeyPressed(KeyEvent.VK_W)){
			this.yMotion = -2;
		}else if(Input.isKeyPressed(KeyEvent.VK_S)){
			this.yMotion = 2;
		}
		if(Input.isKeyPressed(KeyEvent.VK_A)){
			this.xMotion = -2;
		}else if(Input.isKeyPressed(KeyEvent.VK_D)){
			this.xMotion = 2;
		}
		if(Input.isControllerConnected()){
			this.xMotion = Input.getController().getXAxisValue() * 2;
			this.yMotion = Input.getController().getYAxisValue() * 2;
		}
	}

}
