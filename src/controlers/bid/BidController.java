package controlers.bid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.bid.BiddingService;
import models.contract.ContractService;
import models.entity.Bid;
import models.entity.Contract;
import models.entity.ProductStock;
import models.entity.User;
import models.login.LoginService;
import models.notification.NotificationService;
import models.product.ProductStockService;
import models.profile.ProfilesService;
import models.report.ReportService;

/**
 * Servlet implementation class BidController
 */
@WebServlet("/BidController")
public class BidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BidController() {
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
		
		String event =  request.getParameter("tabEvent");
		String selectedBidID = request.getParameter("bids-dropdown");
		String productCategory = request.getParameter("productCategory-dropdown");
		String frequency = request.getParameter("frequency-dropdown");
		String individualBidSubmit = request.getParameter("individualBidSubmit");
		String productStockID = request.getParameter("productStockID");
		String retailerPrice = request.getParameter("retailerPrice");
		HttpSession session = request.getSession(true);
		User user = ProfilesService.getProfileServiceInstance(getServletContext()).getProfile((String)session.getAttribute("username"));
		long farmerID = user.getUserID();
		if(selectedBidID != null)
		{
			response.setContentType("application/pdf");
			long selctedBidId = Long.valueOf(selectedBidID);
			Bid bid = BiddingService.getBiddingServiceInstance(LoginService.getServeletContext()).getBid(selctedBidId);
			Contract contract = ContractService.getContractServiceInstance(getServletContext()).createContract(bid);
			String message = ReportService.getReportServiceInstance().printContract(contract, "PDF", response);
			if( !message.equals( "" ))
			{
				response.setContentType("application/json");
				
				response.getWriter().append(message);
			}
		}
		else if(productCategory != null)
		{
			// update notifications for users		
			NotificationService.getNotificationServiceInstance().updateFarmersForProductNotification( productCategory ,request.getParameter("quantity"),request.getParameter("price"),frequency,user.getUserID());
		}
		else if("individualBid".equals( individualBidSubmit ))
		{
			// this is individual bid submitting
			response.setContentType("application/json");
			ProductStock stock = ProductStockService.getProductStockServiceInstance( getServletContext() ).getProductStockByID( productStockID );
			
			response.getWriter().append(BiddingService.getBiddingServiceInstance( getServletContext() ).addBid( stock, user.getUserID(), Double.parseDouble( retailerPrice ) ));
		}
		else
		{
			response.setContentType("application/json");
			response.getWriter().append(BiddingService.getBiddingServiceInstance( getServletContext() ).getFarmerBids( farmerID ));
		}		
	}

}
