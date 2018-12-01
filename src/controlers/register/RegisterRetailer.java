package controlers.register;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.entity.Contract;
import models.profile.ProfilesService;
import models.report.ReportService;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterRetailer")
public class RegisterRetailer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterRetailer() {
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
		String business_name = request.getParameter("business_name");
		String business_address = request.getParameter("business_address");
		String business_tel = request.getParameter("business_tel");
		String business_fax = request.getParameter("business_fax");
		response.setContentType("application/json");
		response.getWriter().append(ProfilesService.getProfileServiceInstance(getServletContext()).addRetailerProfile( username, password, business_name, business_address, business_fax, business_tel ));
	}

}
