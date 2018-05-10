package info.searchman;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		/*
		 * response.setContentType("text/html"); PrintWriter out =
		 * response.getWriter(); out.println("<html>"); out.println("<head>");
		 * out.println("<title>Hello World!</title>"); out.println("</head>");
		 * out.println("<body>"); out.println("<h1>Hello World!</h1>");
		 * out.println("</body>"); out.println("</html>");
		 */

	    String value = request.getParameter("hoge");
	    System.out.println(value);

		request.setAttribute("foo", "bar");

		String view = "/WEB-INF/view/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 文字コードの指定
	    request.setCharacterEncoding("utf-8");
	    // formから値を取得
	    String name = request.getParameter("name");

	    request.setAttribute("userName", name);

	    doGet(request, response);
	}
}