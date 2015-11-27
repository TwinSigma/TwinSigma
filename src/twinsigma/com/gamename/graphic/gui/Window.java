package twinsigma.com.gamename.graphic.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import twinsigma.com.gamename.GameName;

public abstract class Window {
	
	public JFrame frame;
	public JPanel panel;
	
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	
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
		panel.addComponentListener(new ComponentAdapter(){
			@Override
			public void componentResized(ComponentEvent e){
				WIDTH = e.getComponent().getWidth();
				HEIGHT = e.getComponent().getHeight();
				GameName.getInstance().resizeGui();
			}
		});
		panel.setDoubleBuffered(true);
		frame.add(panel);
		frame.pack();
		frame.setSize(800, 600);
		WIDTH = panel.getWidth();
		HEIGHT = panel.getHeight();
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
