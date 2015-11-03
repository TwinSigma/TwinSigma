package twinsigma.com.gamename;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import twinsigma.com.gamename.graphic.gui.Gui;
import twinsigma.com.gamename.graphic.gui.LogoGui;
import twinsigma.com.gamename.graphic.gui.TextFieldGui;
import twinsigma.com.gamename.graphic.gui.Window;
import twinsigma.com.gamename.managers.ResourceManager;

public class GameName implements KeyListener{
	
	public Window window;
	public Gui currentGui;
	public ResourceManager resourceManager;
	
	public GameName(){
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
				window.addKeyListener(GameName.this);
				resourceManager.loadAllResources();
				gameLoop.start();
			}
		};
		init.start();
	}
	
	public void gameLoop(){
		while(true){
			
			window.repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void drawScreen(Graphics2D g2d){
		currentGui.draw(g2d);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		currentGui.onType(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		currentGui.onUnType(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
