import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

/*
 * Toy example - respond when name parameter is given.
 *
*/
public class Check extends HttpServlet {

	private String message;

	public void init() throws ServletException {

		message = "";
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.setHeader("Access-Control-Allow-Origin", "*");

		PrintWriter out = response.getWriter();
		message = "error";

		Enumeration paramNames = request.getParameterNames();

		while(paramNames.hasMoreElements()) {

			String paramName = (String)paramNames.nextElement();
			if( paramName.equals("name")) {

				String[] paramValues = request.getParameterValues(paramName);

				if (paramValues.length == 1) {
					String paramValue = paramValues[0];
					if (paramValue.length() != 0) {

						if( paramValue.equals( "selcuk")) {

							message = "selcuk gulcan";
						}

						else if( paramValue.equals( "celal")) {

							message = "celal selcuk karaca";
						}

						else if( paramValue.equals( "ali")) {

							message = "seref ali yataman";
						}

						else if( paramValue.equals( "xalig")) {

							message = "xalig novruzli";
						}
					}
				}
			}
		}

		out.println( message);
	}

	public void destroy() {

	}
}