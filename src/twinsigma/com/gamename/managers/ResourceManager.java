package twinsigma.com.gamename.managers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.imageio.ImageIO;

import twinsigma.com.gamename.graphic.Sprite;

public class ResourceManager {
	
	public static final String texPath = "/twinsigma/com/gamename/resources/textures/";
	public static final String sprPath = "/twinsigma/com/gamename/resources/sprites/";
	
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
	
	public Sprite loadSprite(String name){
		try{
			BufferedImage[] frames = new BufferedImage[0];
			int fps = 1;
			FileInputStream fis = new FileInputStream(sprPath + name + ".spr");
			byte[] first = new byte[1];
			while(fis.read(first) != -1){
				byte[] toRead = new byte[0];
				if(new String(first).equals("f")){
					while(fis.read(first) != -1){
						toRead = Arrays.copyOf(toRead, toRead.length+1);
						toRead[toRead.length-1] = first[0];
					}
					fps = Integer.parseInt(new String(toRead));
					break;
				}
				while(!new String(first).equals("\n")){
					toRead = Arrays.copyOf(toRead, toRead.length+1);
					toRead[toRead.length-1] = first[0];
					fis.read(first);
				}
				int read = Integer.parseInt(new String(toRead));
				byte[] bImg = new byte[read];
				fis.read(bImg);
				fis.skip(1);
				frames = Arrays.copyOf(frames, frames.length+1);
				ByteArrayInputStream bias = new ByteArrayInputStream(bImg);
				frames[frames.length-1] = ImageIO.read(bias);
			}
			fis.close();
			return new Sprite(fps, frames);
		}catch (IOException e){
			System.err.println("Failed to load sprite " + name);
			System.exit(-1);
		}
		return null;
	}

}