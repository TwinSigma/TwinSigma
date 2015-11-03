package twinsigma.com.gamename.managers;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceManager {
	
	public static final String texPath = "/twinsigma/com/gamename/resources/textures/";
	
	private static BufferedImage logo;
	
	public ResourceManager(){
		
	}
	
	public void loadLogo(){
		logo = loadResource("logo.png");
	}
	
	public void loadAllResources(){
		
	}
	
	public static BufferedImage getLogo(){
		return logo;
	}
	
	public BufferedImage loadResource(String name){
		try {
			BufferedImage ret = ImageIO.read(this.getClass().getResource(texPath + name));
			return ret;
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Failed to load image " + name);
		}
		return null;
	}

}
