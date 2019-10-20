package jacky.script.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jacky.script.service.ScriptService;

/**
 * Servlet implementation class ScriptServlet
 */
@WebServlet("/ScriptServlet")
public class ScriptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	static List<String> words = new ArrayList<String>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("scriptWithAnswer");
		request.getSession().removeAttribute("words");
		request.getSession().removeAttribute("title");
		
		
		
		String title = request.getParameter("course");
		request.getSession().setAttribute("title",title);
		
		ScriptService ss = new ScriptService();
		
		//獲取依照標題文件查詢的html 文檔
		//String script = ss.getScript(title);
		
		//獲取依照標題文件查詢並有隨機抓取空格的文檔
		//String scriptWithSpace = ss.getScriptWithSpace(title);
		String script = "";
		Map<String, List<String>> map = ss.getScriptWithSpaceAndAnswers(title);
		for(String s : map.keySet()) {
			script = s;
			words = map.get(script);
		}
		
		request.getSession().setAttribute("words", words);
		
		String scriptWithSpace = changeSpaceToInput(script);
		request.setAttribute("script", scriptWithSpace);
		
		String scriptWithAnswer = changeSpaceToAnswer(script);
		
		String url = "/English.jsp?course=" + title ;
		
		request.getSession().setAttribute("scriptWithAnswer", scriptWithAnswer);
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private static String changeSpaceToInput(String script) {

		script = script.replace("______", ("<input type='text' name='words' size='5'/>"));
		return script;
	
	}

	private static String changeSpaceToAnswer(String script) {
		
		for(String word :words) {
			script = script.replaceFirst("______", ("<input type='text' name='words' size='5' value = '"
					+ word
					+ "' style = 'color:black'/>"));
			
		}
		return script;
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
