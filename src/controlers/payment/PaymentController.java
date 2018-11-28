package controlers.payment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.contract.ContractService;
import models.entity.Contract;
import models.payment.PaymentService;

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

		String account = request.getParameter("account-dropdown");
		String addFundsAccount = request.getParameter("addfunds-dropdown");
		if(fundAmount != null)
		{
			response.getWriter().append(PaymentService.getPaymentServiceInstance( getServletContext() ).addFundsToAccount( Double.parseDouble( fundAmount ), addFundsAccount ));
		}
		else if(selectedContractID != null)
		{
			Contract contract = ContractService.getContractServiceInstance( getServletContext() ).getContractByID(selectedContractID);
			response.getWriter().append(PaymentService.getPaymentServiceInstance( getServletContext() ).makePayment( contract, account ));
		}			
	}

}
