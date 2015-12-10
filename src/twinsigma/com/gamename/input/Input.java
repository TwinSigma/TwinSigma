package twinsigma.com.gamename.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import twinsigma.com.gamename.GameName;

public class Input implements KeyListener, MouseListener{
	
	private static boolean[] key = new boolean[600];
	private static boolean[] mouse = new boolean[3];
	
	public static boolean isKeyPressed(int k){
		return key[k];
	}
	
	public static boolean isMousePressed(int mb){
		return mouse[mb];
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {
		mouse[arg0.getButton()-1] = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		mouse[arg0.getButton()-1] = false;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		GameName.getInstance().currentGui.onType(arg0.getKeyCode());
		key[arg0.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		GameName.getInstance().currentGui.onUnType(arg0.getKeyCode());
		key[arg0.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
