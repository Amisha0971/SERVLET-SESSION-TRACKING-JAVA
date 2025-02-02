package Cokkies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
	        PrintWriter out = response.getWriter();


	        Cookie[] cookies = request.getCookies(); // Getting cookies
	        if (cookies != null) {
	            String name = null;
	            for (Cookie ck : cookies) {
	                if ("name".equals(ck.getName())) {
	                    name = ck.getValue();
	                    break;
	                }
	            }

	            if (name != null && !name.isEmpty()) {
	                out.print("<b>Welcome to your Profile</b>");
	                out.print("<br>Welcome, " + name);
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
