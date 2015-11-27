package twinsigma.com.gamename.elements;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Scene {
	
	public ArrayList<SceneElement> elements = new ArrayList<SceneElement>();
	public ArrayList<MovableElement> moveElements = new ArrayList<MovableElement>();
	
	public Scene(SceneElement... element){
		for(SceneElement e : element){
			if(e instanceof MovableElement){
				moveElements.add((MovableElement) e);
			}else{
				elements.add(e);
			}
		}
	}
	
	public void update(){
		for(MovableElement e : moveElements){
			e.update(this);
		}
	}
	
	public void render(Graphics2D g2d){
		for(SceneElement e : elements){
			e.getSprite().render(g2d, e.x, e.y, e.width, e.height, e.rotation);
		}
		for(MovableElement e : moveElements){
			e.getSprite().render(g2d, e.x, e.y, e.width, e.height, e.rotation);
		}
	}
	
	public void screenChange(){
		for(SceneElement e : elements){
			e.screenChange();
		}
		for(MovableElement e : moveElements){
			e.screenChange();
		}
	}

}
