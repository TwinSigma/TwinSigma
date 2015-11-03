package twinsigma.com.gamename.util;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import twinsigma.com.gamename.graphic.gui.Gui;

public class StringUtil {
	
	public static void drawYCentered(Graphics2D g2d, Gui gui, String text){
		Rectangle2D b = g2d.getFontMetrics().getStringBounds(text, g2d);
		double height = b.getHeight();
		g2d.drawString(text, gui.x + 2, (int) (gui.y + (gui.height/2) + height/2));
	}

}
