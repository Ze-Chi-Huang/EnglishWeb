package jacky.script.web.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckAnswerServlet
 */
@WebServlet("/CheckAnswerServlet")
public class CheckAnswerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> words = (List<String>) request.getSession().getAttribute("words");
		String[] wordsinput = request.getParameterValues("words");
		String scriptWithAnswer = (String) request.getSession().getAttribute("scriptWithAnswer");
		
		//System.out.println(words);
		for(int i=0;i<words.size();i++) {
			System.out.println(wordsinput[i] + " " + words.get(i));
			if(!wordsinput[i].replace(".", "").replace("?", "").replace("!", "").equals(words.get(i))){
				System.out.println("enter!");
				String word = words.get(i);
				String before = "<input type='text' name='words' size='5' value = '"
						+ word
						+ "' style = 'color:black'/>";
				
				String after = "<input type='text' name='words' size='5' value = '"
						+ word
						+ "' style = 'color:red'/>";
				//Εά¬υ¦β¦r
				
				scriptWithAnswer = scriptWithAnswer.replace(before, after);
				//System.out.println(scriptWithAnswer);
			}
		}
		String title = (String) request.getSession().getAttribute("title");
		String url = "/English.jsp?course=" + title ;
		request.getSession().setAttribute("script", scriptWithAnswer);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
