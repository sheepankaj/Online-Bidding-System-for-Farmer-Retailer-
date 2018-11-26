package controlers.payment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.bid.BiddingService;
import models.contract.ContractService;
import models.entity.Contract;
import models.entity.User;
import models.payment.BankAccount;
import models.payment.NotEnoughBalanceException;
import models.payment.PamentDetailsNotUpdatedException;
import models.payment.PaymentService;
import models.profile.ProfilesService;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
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
		response.setContentType("application/json");
		String selectedContractID = request.getParameter("contract-dropdown");
		String fundAmount = request.getParameter("fundAmount");
		Contract contract = ContractService.getContractServiceInstance( getServletContext() ).getContractByID(selectedContractID);
		String account = request.getParameter("account-dropdown");
		if(fundAmount != null)
		{
			response.getWriter().append(PaymentService.getPaymentServiceInstance( getServletContext() ).makePayment( contract, account ));
		}
		else
		{
			response.getWriter().append(PaymentService.getPaymentServiceInstance( getServletContext() ).makePayment( contract, account ));
		}			
	}

}
