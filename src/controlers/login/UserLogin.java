package controlers.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.bid.BiddingService;
import models.contract.ContractService;
import models.entity.Contract;
import models.entity.Farmer;
import models.entity.Product;
import models.entity.User;
import models.login.LoginService;
import models.notification.NotificationManager;
import models.notification.NotificationService;
import models.payment.PaymentService;
import models.product.ProductService;
import models.profile.ProfilesService;
import models.report.ReportService;

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
		LoginService.setServletContext( getServletContext() );
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);

		session.setAttribute("username", request.getParameter("username"));
		//session.setAttribute("password", request.getParameter("password"));
		//#PaymentService.getPaymentServiceInstance( getServletContext() );
		//#BiddingService.getBiddingServiceInstance( getServletContext()).getBids();
		//#ContractService.getContractServiceInstance(getServletContext());
		//ReportService.getReportServiceInstance().printContract(new Contract, docType, response);
		
		// to get the username and password
//		String userName = session.getAttribute("username");
//		String password = session.getAttribute("password");
		response.setContentType("application/json");
		//#ProductService.getProductServiceInstance( getServletContext() );		
		User user = null;
		if(ProfilesService.getProfileServiceInstance(getServletContext()).validLoginCheck( username, password ))
		{
			user = ProfilesService.getProfileServiceInstance(getServletContext()).getProfile(username);
			//response.getWriter().append("{\"state\":\"Success\",\"message\":\"Login Successfull..!!\",\"page\""+":\""+user.getProfileType()+"\"}");
			response.getWriter().append("{\"state\":\"Success\",\"message\":\"Login Successfull..!!\",\"page\""+":\""+user.getProfileType()+"\",\"name\":\""+user.getUsername()+"\"}");
		}
		else
		{
			response.getWriter().append(ProfilesService.getProfileServiceInstance(getServletContext()).validLogin( username, password ));
		}		
	}

}
