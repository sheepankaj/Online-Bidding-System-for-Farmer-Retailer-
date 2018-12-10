package models.login;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	//to encrypt the password entered by the user
	public static String getMD5HashString(String passwordPlainString)
	{
		String md5Hash = "";
		MessageDigest md;
		StringBuilder sb = new StringBuilder();//mutable
		try
		{
			md = MessageDigest.getInstance("MD5");
			byte[] hashInBytes = md.digest(passwordPlainString.getBytes(StandardCharsets.UTF_8));	        
	        for (byte b : hashInBytes) {
	            sb.append(String.format("%02x", b));//conversion of byte by byte into algorithm
	        }
	        md5Hash = sb.toString();
		}
		catch ( NoSuchAlgorithmException e )
		{
			e.printStackTrace();
		}
        return md5Hash;
	}
}
