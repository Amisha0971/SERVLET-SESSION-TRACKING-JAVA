package URLRewriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/URLLoginServlet")
public class URLLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String name = request.getParameter("name");
	        String password = request.getParameter("password");

	        if ("admin123".equals(password)) {
	            // URL rewriting: appending name to the URL
	            out.print("<h1>Welcome, " + name + "!</h1>");
	            out.print("<a href='WelcomeServlet?name=" + name + "'>Go to Welcome Page</a>");
	        } else {
	            out.print("Invalid Credentials. Please try again.");
	            request.getRequestDispatcher("index.html").include(request, response);
	        }

	        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
	}

}
