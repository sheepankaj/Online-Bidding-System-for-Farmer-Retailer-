package models.login;

import javax.servlet.ServletContext;

public class LoginService
{
	private static ServletContext context;
//	private static LoginService instance;
//	
//	private LoginService()
//	{
//		
//	}
//	
//	public static LoginService getLoginServiceInstance()
//	{
//		if(instance == null)
//		{
//			instance = new LoginService();
//		}
//		return instance;
//	}
	
	public static ServletContext getServeletContext()
	{
		return context;
	}
	
	public static void setServletContext(ServletContext context)
	{
		if(LoginService.context == null)
		{
			LoginService.context = context;
		}		
	}
}
