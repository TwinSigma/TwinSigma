package twinsigma.com.gamename.graphic.gui;

import java.awt.Graphics2D;

import twinsigma.com.gamename.GameName;
import twinsigma.com.gamename.elements.Scene;

public class InGameGui extends Gui{
	
	public Scene scene;

	public InGameGui() {
		super(0, 0, Window.WIDTH, Window.HEIGHT);
		scene = GameName.getInstance().scene;
	}
	
	@Override
	public void screenUpdate(){
		scene.screenChange();
	}
	
	public void update(){
		scene.update();
	}

	@Override
	public void draw(Graphics2D g2d) {
		scene.render(g2d);
	}

}
