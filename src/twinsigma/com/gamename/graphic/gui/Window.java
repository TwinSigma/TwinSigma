package twinsigma.com.gamename.graphic.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Window {
	
	public JFrame frame;
	public JPanel panel;
	
	public Window(){
		frame = new JFrame("Twin Sigma");
		frame.setBackground(Color.black);
		panel = new JPanel(){
			@Override
			public void paintComponent(Graphics g){
				Graphics2D g2d = (Graphics2D) g;
				super.paintComponents(g2d);
				drawScreen(g2d);
			}
		};
		panel.setDoubleBuffered(true);
		frame.add(panel);
		frame.pack();
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void addKeyListener(KeyListener l){
		frame.addKeyListener(l);
	}
	
	public void repaint(){
		frame.repaint();
	}
	
	public abstract void drawScreen(Graphics2D g2d);

}
