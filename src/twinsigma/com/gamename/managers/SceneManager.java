package twinsigma.com.gamename.managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import twinsigma.com.gamename.elements.SceneElement;

public class SceneManager {
	
	public static final String scenePath = "/twinsigma/com/gamename/resources/scenes/";
	
	public SceneManager(){}
	
	public void parseScene(String name)throws FileNotFoundException{
		File file = new File(this.getClass().getResource(name + ".scn").getFile());
		if(!file.exists()){
			throw new FileNotFoundException("Scene " + name + ".scn does not exist!");
		}
		BufferedReader reader = new BufferedReader(new FileReader(file));
		try {
			parseInit(reader);
		} catch (SceneSyntaxException e) {
			e.printStackTrace();
		}
	}
	
	private String nextLine(BufferedReader reader){
		String line = "";
		try {
			while((line = reader.readLine()).isEmpty() || line.startsWith("//")){}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
	
	private String[] readTo(BufferedReader reader, String s){
		String[] lines = new String[0];
		String line = "";
		while(!(line = nextLine(reader)).startsWith(s)){
			String[] temp = new String[lines.length+1];
			System.arraycopy(lines, 0, temp, lines.length, lines.length);
			lines = temp;
		}
		return lines;
	}
	
	private void parseInit(BufferedReader reader) throws SceneSyntaxException{
		String first = nextLine(reader);
		HashMap<String,SceneElement> variables = new HashMap<String,SceneElement>();
		if(first.equals("init{")){
			String[] lines = readTo(reader, "}");
			for(String line : lines){
				if(line.startsWith("var")){
					line = line.substring(4);
					String name = line.substring(0, line.indexOf("="));
					
				}
			}
		}else{
			throw new SceneSyntaxException("No initialization block!");
		}
	}

}
