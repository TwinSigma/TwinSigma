package twinsigma.com.gamename.graphic.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import twinsigma.com.gamename.util.StringUtil;

public class TextFieldGui extends Gui{
	
	private String preText;
	public String text;
	public String selected;
	public int caret;
	
	private BufferedImage caretImg;
	
	private Clipboard clip;
	
	private boolean isShift;
	private boolean isControl;
	
	private int flicker;
	
	public TextFieldGui(int x, int y, int width){
		this(x, y, width, "");
	}
	
	public void update(){
		flicker++;
		if(flicker > 60) flicker = 0;
	}

	public TextFieldGui(int x, int y, int width, String preText) {
		super(x, y, width, 15);
		this.preText = preText;
		text = "";
		selected = "";
		caret = 0;
		clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		caretImg = new BufferedImage(1, 12, BufferedImage.TYPE_INT_RGB);
	}
	
	public void onType(int c){
		switch(c){
		case KeyEvent.VK_SHIFT:
			isShift = true;
			break;
		case KeyEvent.VK_CONTROL:
			isControl = true;
			break;
			default:
				if(isControl){
					if(c==KeyEvent.VK_V){
						try {
							this.insertText((String) clip.getData(DataFlavor.stringFlavor));
						} catch (UnsupportedFlavorException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else if(c==KeyEvent.VK_C){
						if(!selected.isEmpty()){
							StringSelection sel = new StringSelection(selected);
							clip.setContents(sel, sel);
						}
					}else if(c==KeyEvent.VK_X){
						if(!selected.isEmpty()){
							StringSelection sel = new StringSelection(selected);
							clip.setContents(sel, sel);
							text = text.substring(caret, selected.length());
						}
					}
				}else if(isShift){
					if(c==KeyEvent.VK_LEFT){
						selected = text.substring(caret-1, caret) + selected;
					}else if(c==KeyEvent.VK_RIGHT){
						selected = selected + text.substring(caret, caret+1);
					}else{
						insertText(""+Character.toUpperCase((char) c));
					}
				}else{
					if(c==KeyEvent.VK_RIGHT){
						caret++;
						if(caret > text.length()) caret = text.length();
					}else if(c==KeyEvent.VK_LEFT){
						caret--;
						if(caret < 0) caret = 0;
					}
					else if(this.isCharacterAcceptable(c)) insertText(""+Character.toLowerCase((char) c));
				}
				break;
		}
	}
	
	private boolean isCharacterAcceptable(int c){
		return true;
	}
	
	public void onUnType(int c){
		switch(c){
		case KeyEvent.VK_SHIFT:
			isShift = false;
			break;
		case KeyEvent.VK_CONTROL:
			isControl = false;
			break;
		}
	}
	
	public void insertText(String in){
		text = text.substring(0, caret) + in + text.substring(caret);
		caret += in.length();
	}
	
	public String getText(){
		return text;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.draw(this.getBounds());
		g2d.setColor(Color.black);
		if(text.isEmpty()){
			g2d.setColor(Color.gray);
			StringUtil.drawYCentered(g2d, this, preText);
			g2d.setColor(Color.black);
		}else StringUtil.drawYCentered(g2d, this, text);
		Rectangle2D tBound = g2d.getFontMetrics().getStringBounds(text.substring(0, caret), g2d);
		if(flicker < 31){
			g2d.drawImage(caretImg, (int) (this.x + tBound.getWidth() + 2), this.y + 2, null);
		}
	}

}
