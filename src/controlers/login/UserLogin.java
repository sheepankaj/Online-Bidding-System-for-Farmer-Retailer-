package controlers.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.entity.ProfileType;
import models.entity.User;
import models.product.ProductService;
import models.profile.ProfilesService;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("application/json");
		ProductService.getProductServiceInstance( getServletContext() );		
		User user = null;
		if(ProfilesService.getProfileServiceInstance(getServletContext()).validLoginCheck( username, password ))
		{
			user = ProfilesService.getProfileServiceInstance(getServletContext()).getProfile(username);
			response.getWriter().append("{\"state\":\"Success\",\"message\":\"Login Successfull..!!\",\"page\""+":\""+user.getProfileType()+"\"}");
		}
		else
		{
			response.getWriter().append(ProfilesService.getProfileServiceInstance(getServletContext()).validLogin( username, password ));
		}		
	}

}
