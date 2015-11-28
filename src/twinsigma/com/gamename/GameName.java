package twinsigma.com.gamename;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import twinsigma.com.gamename.elements.Background;
import twinsigma.com.gamename.elements.Player;
import twinsigma.com.gamename.elements.Scene;
import twinsigma.com.gamename.graphic.gui.Gui;
import twinsigma.com.gamename.graphic.gui.LogoGui;
import twinsigma.com.gamename.graphic.gui.TextFieldGui;
import twinsigma.com.gamename.graphic.gui.Window;
import twinsigma.com.gamename.input.Input;
import twinsigma.com.gamename.managers.ResourceManager;

public class GameName{
	
	public Window window;
	public Gui currentGui;
	public ResourceManager resourceManager;
	
	public Scene scene;
	
	private static GameName instance;
	
	public GameName(){
		instance = this;
		Thread gameLoop = new Thread("Game Loop"){
			@Override
			public void run(){
				gameLoop();
			}
		};
		Thread init = new Thread("Initialization"){
			@Override
			public void run(){
				resourceManager = new ResourceManager();
				resourceManager.loadLogo();
				currentGui = new LogoGui();
				window = new Window(){
					@Override
					public void drawScreen(Graphics2D g2d) {
						GameName.this.drawScreen(g2d);
					}
				};
				window.addKeyListener(new Input());
				resourceManager.loadAllResources();
				scene = new Scene(new Background(0, 0, Window.WIDTH, Window.HEIGHT, 0, ResourceManager.grass),
						new Player(10, 10, 50, 50, 0, ResourceManager.player));
				gameLoop.start();
			}
		};
		init.start();
	}
	
	public void gameLoop(){
		while(true){
			currentGui.update();
			window.repaint();
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void drawScreen(Graphics2D g2d){
		currentGui.draw(g2d);
	}
	
	public static GameName getInstance(){
		return instance;
	}
	
	public void resizeGui(){
		this.currentGui.screenUpdate();
	}

}
