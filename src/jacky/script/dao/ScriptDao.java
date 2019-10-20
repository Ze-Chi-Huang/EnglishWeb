package jacky.script.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ScriptDao {
	
	List<String> wordsAnswers = new ArrayList<>();
	//�⦳���u���r��򵪮ץ]��map �ǥX�h
	Map<String, List<String>> scriptWithSpaceAndAnswers = new HashMap<String, List<String>>();
	
	//��o���D
	public String getTitle() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\workspace\\eclipseWeb\\EnglishWeb\\WebContent\\myTitle.txt"));
			
			StringBuilder sb = new StringBuilder();
			String line = "";
			
			while((line = br.readLine())!= null) {
				
				String[] datas = line.split("\\|");
				sb.append(datas[1] + "\n");
				
			}
			
			br.close();
			
			return sb.toString();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "";
	}
	
	private List<String> getWordsAnswers(){
		return wordsAnswers;
	}
	
	public Map<String, List<String>> getScriptWithSpaceAndAnswers(String name){
		scriptWithSpaceAndAnswers.put(this.getScriptWithSpace(name),this.getWordsAnswers());
		//wordsAnswers.clear();
		return scriptWithSpaceAndAnswers;
	}
	
	
	
	//�����u�����
	public String getScriptWithSpace(String name) {
		
		Random rand = new Random();
		
		ScriptDao sd = new ScriptDao();
		String[] script = sd.getScript(name).split("\n");
		StringBuilder sb = new StringBuilder();
		
		for(String s : script) {
			
			String[] words = s.split(" ");
			
			//�C�@��D�@��
			int randindex = rand.nextInt(words.length-1)+1;
			wordsAnswers.add(words[randindex]);
			words[randindex] = "______";

			Arrays.asList(words).forEach(str -> sb.append(str + " "));
			sb.append("<br>");
			//System.out.println();
			//System.out.println(s);
		}
		
		return sb.toString();
	}
	
	//��l���
	public String getScript(String name) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\workspace\\eclipseWeb\\EnglishWeb\\WebContent\\script\\" + name + ".txt"));
			
			StringBuilder sb = new StringBuilder();
			String line = "";
			
			while((line = br.readLine())!= null) {
				
				line = line.replace("[", "").replace("]","").replace("<i>", "").replace("</i>", "")
						.replace("<b>", "").replace("</b>", "").replace("??", " ");
				sb.append(line + "\n");
				
			}
			
			br.close();
			
			return sb.toString();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "";
	}
}
