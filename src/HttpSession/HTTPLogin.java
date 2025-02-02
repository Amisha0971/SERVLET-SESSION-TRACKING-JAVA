package HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HTTPLogin")
public class HTTPLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String name = request.getParameter("name");
	        String password = request.getParameter("password");

	        if ("admin123".equals(password)) {
	            HttpSession session = request.getSession(); // Create a new session
	            session.setAttribute("name", name); // Store username in session
	            out.print("You are successfully logged in!");
	            out.print("<br>Welcome, " + name);
	            out.print("<br><a href='HTTPSessionProfileServlet'>Go to Profile</a>");
	        } else {
	            out.print("Invalid username or password!");
	            request.getRequestDispatcher("index.html").include(request, response);
	        }

	        out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
