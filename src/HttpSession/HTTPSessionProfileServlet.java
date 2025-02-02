package HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/HTTPSessionProfileServlet")
public class HTTPSessionProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false); // Fetch existing session
        if (session != null) {
            String name = (String) session.getAttribute("name");
            if (name != null && !name.isEmpty()) {
                out.print("<h1>Welcome to your profile, " + name + "!</h1>");
                out.print("<br><a href='HttpSessionLogoutServlet'>Logout</a>");
            } else {
                out.print("Please login first!");
                request.getRequestDispatcher("login.html").include(request, response);
            }
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
