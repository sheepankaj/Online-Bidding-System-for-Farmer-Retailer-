package controlers.notification;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.entity.Farmer;
import models.profile.ProfilesService;

/**
 * Servlet implementation class NotificationController
 */
@WebServlet("/NotificationController")
public class NotificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		response.setContentType("application/json");
		Farmer user = (Farmer)ProfilesService.getProfileServiceInstance(getServletContext()).getProfile((String)session.getAttribute("username"));
		if(user.getMessageQueue() != null && user.getMessageQueue().size()> 0)
		{
			// has messages, will poll and return to client
			String topmessage = user.getMessageQueue().poll();
			response.getWriter().append("{\"state\":\"HasMessage\",\"message\":\""+topmessage+"\"}");
		}
		else
		{
			response.getWriter().append("{\"state\":\"NoMessage\"}");
		}
	}

}
