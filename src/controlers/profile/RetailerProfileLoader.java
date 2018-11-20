package controlers.profile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.contract.ContractService;
import models.entity.Farmer;
import models.entity.Retailer;
import models.product.ProductService;
import models.profile.ProfilesService;

/**
 * Servlet implementation class FarmerProfileLoader
 */
@WebServlet("/RetailerProfileLoader")
public class RetailerProfileLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  RetailerProfileLoader() {
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
		String event =  request.getParameter("tabEvent");
		response.setContentType("application/json");
		
		if(event != null &&  event.equals("Manage Contracts"))
		{
			//response.getWriter().append(ContractService.getContractServiceInstance(getServletContext()).getRetailerContracts(retailerID));
			int quant = Integer.parseInt(request.getParameter("quantity"));
		 	double price =Double.parseDouble(request.getParameter("price"));		    
		}
		else
		{
			HttpSession session = request.getSession(true);
			Farmer user = (Farmer)ProfilesService.getProfileServiceInstance(getServletContext()).getProfile((String)session.getAttribute("username"));		
			response.getWriter().append("{\"state\":\"Success\",\"message\":\"Login Successfull..!!\",\"page\":\""+user.getUsername()+"\",\"id\":"+user.getUserID()+"}");			
		}
		
	}

}
