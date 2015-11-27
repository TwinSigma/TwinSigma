package twinsigma.com.gamename.graphic.gui;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import twinsigma.com.gamename.GameName;
import twinsigma.com.gamename.managers.ResourceManager;

public class LogoGui extends Gui{
	
	public int wait;

	public LogoGui() {
		super(0, 0, Window.WIDTH, Window.HEIGHT);
	}
	
	public void update(){
		wait++;
		if(wait == 120){
			GameName.getInstance().currentGui = new InGameGui();
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		BufferedImage logo = ResourceManager.getLogo();
		g2d.drawImage(logo,(int) (x + width/2 - logo.getWidth()/1.9d), (int) (y + height/2 - logo.getHeight()*1.5d), null);
	}
	
	public void screenUpdate(){
		this.width = Window.WIDTH;
		this.height = Window.HEIGHT;
	}

}
