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
	private Map<String, String> members;

	public void init() throws ServletException {

		message = "";
		members = new HashMap<String, String>();

		members.put( "selcuk", "selcuk gulcan");
		members.put( "celal", "celal selcuk karaca");
		members.put( "ali", "seref ali yataman");
		members.put( "xalig", "xalig novruzli");
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");

		PrintWriter out = response.getWriter();

		Enumeration paramNames = request.getParameterNames();

		if( paramNames.hasMoreElements()) {

			message = "error";

			while(paramNames.hasMoreElements()) {

				String paramName = (String)paramNames.nextElement();
				if( paramName.equals("name")) {

					String[] paramValues = request.getParameterValues(paramName);

					if (paramValues.length == 1) {

						String paramValue = paramValues[0];
						if (paramValue.length() != 0) {

							for (Map.Entry<String, String> entry : members.entrySet()) {

								if( entry.getKey().equals( paramValue)) {

									message = "\"" + entry.getValue() + "\"";
									break;
								}
							}
						}
					}
				}
			}
		}

		else {

			message = "[";
			boolean first = true;
			for (Map.Entry<String, String> entry : members.entrySet()) {

				if( !first) {

					message += ",";
				}
				else {

					first = false;
				}

				message += "\"" + entry.getKey() + "\"";
			}
			message += "]";
		}

		out.println( message);
	}

	public void destroy() {

	}
}