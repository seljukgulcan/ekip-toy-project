import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

/*
 * Toy login example
 *
*/
public class Login extends HttpServlet {

  private String respond;
  private final String USERNAME = "ekip";
  private final String PASSWORD = "123456";

  private final String OK			= "OK";
  private final String BAD_REQUEST	= "BAD";
  private final String WRONG		= "WRONG";

  public void init() throws ServletException {

	respond = BAD_REQUEST;
  }

  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html");

	PrintWriter out = response.getWriter();

	String username, password;

	username = request.getParameter( "username");
	password = request.getParameter( "password");

	if( username == null || password == null) {

		respond = BAD_REQUEST;
	}

	else {

		if( username.equals( USERNAME) && password.equals(PASSWORD)) {

			respond = OK;
		}

		else {

			respond = WRONG;
		}
	}

	out.println( respond);
  }

  public void destroy() {

  }
}