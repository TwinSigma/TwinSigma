package twinsigma.com.gamename.managers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ResourceManager {
	
	public static final String texPath = "/twinsigma/com/gamename/resources/textures/";
	
	private static BufferedImage logo;
	private static HashMap<String,BufferedImage> images = new HashMap<String,BufferedImage>();
	
	public ResourceManager(){
		
	}
	
	public void loadLogo(){
		logo = loadImage("logo");
	}
	
	public void loadAllResources(){
		
	}
	
	public static BufferedImage getImg(String name){
		return images.get(name);
	}
	
	public static BufferedImage getLogo(){
		return logo;
	}
	
	public BufferedImage loadImage(String name){
		BufferedImage ret = null;
		try {
			ret = ImageIO.read(this.getClass().getResource(texPath + name + ".png"));

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Failed to load image " + name);
		}
		images.put(name, ret);
		return ret;
	}

}
