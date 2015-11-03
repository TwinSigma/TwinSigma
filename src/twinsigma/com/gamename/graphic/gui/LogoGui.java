package twinsigma.com.gamename.graphic.gui;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import twinsigma.com.gamename.managers.ResourceManager;

public class LogoGui extends Gui{

	public LogoGui() {
		super(0, 0, 800, 800);
	}

	@Override
	public void draw(Graphics2D g2d) {
		BufferedImage logo = ResourceManager.getLogo();
		g2d.drawImage(logo,(int) (x + width/2 - logo.getWidth()/1.9d), (int) (y + height/2 - logo.getHeight()*1.5d), null);
	}

}
