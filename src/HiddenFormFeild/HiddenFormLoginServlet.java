package HiddenFormFeild;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HiddenFormLoginServlet")
public class HiddenFormLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if ("admin123".equals(password)) {
            out.print("You are successfully logged in!");
            out.print("<br>Welcome, " + name);

            // Pass user information as hidden field
            out.print("<form action='HiddenFormProfileServlet' method='post'>");
            out.print("<input type='hidden' name='name' value='" + name + "'>");
            out.print("<input type='submit' value='Go to Profile'>");
            out.print("</form>");
        } else {
            out.print("Sorry, incorrect username or password!");
            request.getRequestDispatcher("login.html").include(request, response);
        }

        out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
