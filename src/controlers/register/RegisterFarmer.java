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
import models.report.ReportService;

@WebServlet("/RegisterFarmer")
public class RegisterFarmer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterFarmer() {
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
		response.setContentType("application/pdf");
		List<Contract> contracts = new ArrayList<Contract>();
		contracts.add(new Contract());
		contracts.add(new Contract());
		ReportService.getReportServiceInstance().generateContractReport( contracts, "PDF", response );
		//response.getWriter().append(ProfilesService.getProfileServiceInstance(getServletContext()).validLogin( username, password ));
	}

}