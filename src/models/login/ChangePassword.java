package models.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlers.login.UserLogin;
import models.entity.User;
import models.profile.ProfilesService;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. retrive all parameters from JSP pagell
		
		String currentpass=request.getParameter("currentpass");
		String newpass=request.getParameter("newpass");
		String confirmpass=request.getParameter("confirmpass");
		
		HttpSession session = request.getSession();
		String cpass=(String)session.getAttribute("pass");
		String uname=(String)session.getAttribute("username");
		
		if(currentpass.equals(null)||currentpass==""||newpass.equals(null)||newpass==""||confirmpass.equals(null)||confirmpass=="")
		{
			request.setAttribute("msg", "All Fields are mendatory");
			getServletContext().getRequestDispatcher("/adminProfile.jsp").forward(request, response);
		}
		else if (!newpass.equals(confirmpass))
		{
			request.setAttribute("msg", "Password does not match");
			getServletContext().getRequestDispatcher("/adminProfile.jsp").forward(request, response);
		}
		else if (!cpass.equals(currentpass))
		{
			request.setAttribute("msg", "Old Password is not match");
			getServletContext().getRequestDispatcher("/adminProfile.jsp").forward(request, response);
		}
		else
		{
			//set values to Model class Object
			
			UserLogin ul = new UserLogin();
			User user = ProfilesService.getProfileServiceInstance(getServletContext()).getProfile("uname");
			user.setPassword(newpass);
			request.setAttribute("msg", "Password update Successfully");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		}
	} 

}
