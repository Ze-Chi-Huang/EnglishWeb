package jacky.script.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import jacky.script.dao.ScriptDao;

public class ScriptService {
	
	ScriptDao s = new ScriptDao();
	
	public String[] getTitle() {
		return s.getTitle().split("\n");
	}
	
	public String getScript(String name) {

		return s.getScript(name);
	}
	
	public String getScriptWithSpace(String name) {
		
		return s.getScriptWithSpace(name);
		
	}
	/*
	public String getHtmlScript(String name) {
		
		String str =  this.getScript(name);
		String[] datas =  str.split("\n");
		StringBuilder sb = new StringBuilder();
		
		Arrays.asList(datas).forEach(s -> sb.append(s + "<br>"));
		return sb.toString();
	}
	
	public String getHtmlScriptWithSpace(String name) {
		
		String str =  this.getScriptWithSpace(name);
		String[] datas =  str.split("\n");
		StringBuilder sb = new StringBuilder();
		
		Arrays.asList(datas).forEach(s -> sb.append(s + "<br>"));
		return sb.toString();
	}*/
	
	//依照標題去獲取有底線的文檔跟答案
	public Map<String, List<String>> getScriptWithSpaceAndAnswers(String name){
		
		return s.getScriptWithSpaceAndAnswers(name);
	}
}
