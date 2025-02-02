package HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HttpSessionLogoutServlet")
public class HttpSessionLogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        HttpSession session = request.getSession(false); // Fetch existing session
	        if (session != null) {
	            session.invalidate(); // Invalidate the session
	            out.print("You have successfully logged out!");
	        } else {
	            out.print("No active session found!");
	        }

	        out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
