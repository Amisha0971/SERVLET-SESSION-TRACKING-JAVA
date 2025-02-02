package HiddenFormFeild;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HiddenFormProfileServlet")
public class HiddenFormProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String name = request.getParameter("name"); // Retrieve hidden field value

	        if (name != null && !name.isEmpty()) {
	            out.print("<b>Welcome to your Profile</b>");
	            out.print("<br>Welcome, " + name);
	        } else {
	            out.print("Please login first!");
	            request.getRequestDispatcher("login.html").include(request, response);
	        }

	        out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
