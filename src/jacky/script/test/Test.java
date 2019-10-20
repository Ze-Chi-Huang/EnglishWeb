package jacky.script.test;

import jacky.script.dao.ScriptDao;
import jacky.script.service.ScriptService;

public class Test {

	public static void main(String[] args) {
		
		ScriptDao s = new ScriptDao();
		
		//System.out.println(s.getScript("A Day at School"));
		//System.out.print(s.getTitle());
		
		/*ScriptService ss = new ScriptService();
		System.out.println(ss.getScriptWithSpace("A Day at School"));*/
		
		//s.getScriptWithSpaceAndAnswers("A Day at School");
		System.out.println(s.getScriptWithSpaceAndAnswers("A Day at School"));
		//System.out.println(s.getWordsAnswers());
	}

}
