package twinsigma.com.gamename.graphic.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import twinsigma.com.gamename.util.StringUtil;

public class TextFieldGui extends Gui{
	
	private String preText;
	public String text;
	public String selected;
	public int caret;
	
	private Clipboard clip;
	
	private boolean isShift;
	private boolean isControl;
	
	public TextFieldGui(int x, int y, int width){
		this(x, y, width, "");
	}

	public TextFieldGui(int x, int y, int width, String preText) {
		super(x, y, width, 15);
		this.preText = preText;
		text = "";
		selected = "";
		caret = 0;
		clip = Toolkit.getDefaultToolkit().getSystemClipboard();
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
					if(this.isCharacterAcceptable(c)) insertText(""+Character.toLowerCase((char) c));
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
		text += in;
		System.out.println(text);
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
	}

}
