package models.profile;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import models.entity.Admin;
import models.entity.EntityService;
import models.entity.Farmer;
import models.entity.Gold;
import models.entity.NoPriority;
import models.entity.Platinum;
import models.entity.Priority;
import models.entity.ProfileType;
import models.entity.RandomNumberGenerator;
import models.entity.Retailer;
import models.entity.RuntimeTypeAdapterFactory;
import models.entity.Silver;
import models.entity.User;
import models.login.LoginService;

public class ProfilesService extends EntityService
{
	public static ProfilesService profilesService;
	private static List<User> profiles = new ArrayList<>();
	
	static String filePath = "/WEB-INF/db/profile/Profile.json";
	ServletContext context;

	
	private ProfilesService(ServletContext context,String filePath)
	{
		super( context,filePath );
	}
	
	public static ProfilesService getProfileServiceInstance(ServletContext context)
	{
		if(profilesService == null)
		{
			profilesService = new ProfilesService(context,filePath);
			profilesService.loadEntities();
			//profilesService.printMD5s();
			//profilesService.testGSON();
		}
		return profilesService;
	}	
	
	public void addProfile( User profile )
	{
		profiles.add( profile );
	}
	
	public String addRetailerProfile(String username,String password,String companyName,String companyAddress,String fax,String tel)
	{
		String message ="";
		User user = getProfile( username );
		if(user != null)
		{
			// profile exists so cannot add one
			message = "{\"state\":\"success\",\"message\":\"Username already exists\"}";
		}
		else
		{
			Retailer retailer = new Retailer();
			retailer.setPassword( password );
			retailer.setFax( fax );
			retailer.setCompanyAddress( companyAddress );
			retailer.setCompanyName( companyName );
			retailer.setTel( tel );
			retailer.setPassword( LoginService.getMD5HashString( password ) );
			retailer.setUsername( username );
			retailer.setProfileType( ProfileType.RETAILER );
			retailer.setPriority( new NoPriority( "nopriority" ) );
			retailer.setUserID( RandomNumberGenerator.getLongID() );
			profiles.add( retailer );
			message = "{\"state\":\"success\",\"message\":\"Successfully added the profile\"}";
		}		
		return message;
	}
	
	public String addFarmerProfile(String username,String password,String farmAddress,String tel)
	{
		String message ="";
		User user = getProfile( username );
		if(user != null)
		{
			// profile exists so cannot add one
			message = "{\"state\":\"success\",\"message\":\"Username already exists\"}";
		}
		else
		{
			Farmer farmer = new Farmer();
			farmer.setPassword( password );
			farmer.setTelephone( tel );
			farmer.setFarmAddress( farmAddress );
			farmer.setPassword( LoginService.getMD5HashString( password ) );
			farmer.setUsername( username );
			farmer.setUserID( RandomNumberGenerator.getLongID() );
			farmer.setProfileType( ProfileType.FARMER );
			farmer.setPriority( new NoPriority( "nopriority" ) );
			profiles.add( farmer );//adding farmer object into profile list
			message = "{\"state\":\"success\",\"message\":\"Successfully added the profile\"}";
		}		
		return message;
	}
	
	public User getProfile( String username )
	{
		for(User profile : profiles)
		{
			if(profile.getUsername().equals( username ))
			{
				return profile;
			}
		}
		return null;
	}
	
	public static User getProfile( long userID )
	{
		for(User profile : profiles)
		{
			if(profile.getUserID() ==  userID)
			{
				return profile;
			}
		}
		return null;
	}
	
	public String validLogin(String username, String password)
	{
		User user = getProfile( username );
		if(user != null && user.getPassword().equals( password ))
		{
			return "{\"state\":\"Success\",\"message\":\"Login Successfull..!!\"}";
		}
		else if(user == null)
		{
			return "{\"state\":\"Failed\",\"message\":\"Username not found..!\"}";
		}
		else if(user != null && !user.getPassword().equals( password ))
		{
			return "{\"state\":\"Failed\",\"message\":\"Password incorrect!\"}";
		}
		return "{\"state\":\"Failed\",\"message\":\"Unknown Error..!\"}";
	}
	
	public boolean validLoginCheck(String username, String password)
	{
		User user = getProfile( username );
		boolean vaild = false;
		String md5Hashed = LoginService.getMD5HashString( password );
		if(user != null && user.getPassword().equals( md5Hashed ))
		{
			return true;
		}
		else if(user == null)
		{
			return false;
		}
		else if(user != null && !user.getPassword().equals( md5Hashed ))
		{
			return false;
		}
		return vaild;
	}
	
	public boolean validPasswordCheck(String username, String password)
	{
		User user = getProfile( username );
		String md5Hashed = LoginService.getMD5HashString( password );
		boolean vaildPassword = false;
		if(user != null && user.getPassword().equals( md5Hashed ))
		{
			return true;
		}
		else if(user == null)
		{
			return false;
		}
		else if(user != null && !user.getPassword().equals( md5Hashed ))
		{
			return false;
		}
		return vaildPassword;
	}
	
	
	public void loadEntities()
	{
		try
		{
			super.loadEntities();
		}
		catch ( FileNotFoundException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		TypeToken<List<User>> token = new TypeToken<List<User>>() {};
//		profiles = getGson().fromJson(new InputStreamReader(getIs()), token.getType());
//		testGSON();
		
		
		RuntimeTypeAdapterFactory<User> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
			    .of(User.class, "type")
			    .registerSubtype(Farmer.class, "farmer")
			    .registerSubtype(Admin.class, "admin")
			    .registerSubtype(Retailer.class, "retailer");
		RuntimeTypeAdapterFactory<Priority> runtimeTypeAdapterFactory2 = RuntimeTypeAdapterFactory
				.of(Priority.class, "priorityType")
				.registerSubtype(Gold.class, "gold")
				.registerSubtype(Silver.class, "silver")
				.registerSubtype(Platinum.class, "platinum")
				.registerSubtype(NoPriority.class, "nopriority");
		Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).registerTypeAdapterFactory(runtimeTypeAdapterFactory2).create();
		
		
		Type listType = new TypeToken<List<User>>(){}.getType();
		profiles = gson.fromJson(new InputStreamReader(getIs()), listType);
	}
	
	public List<User> getUsers()
	{
		return profiles;
	}
	
	public String getProfilesAsJSON()
	{
		return getGson().toJson(profiles);
	}
	
	public void testGSON()
	{
		List<User> users = new ArrayList<>();
		users.add(new Farmer("sulthan",38329939,"sulthan123","Address1","+353894855578",new Gold("gold"),"farmer"));
		users.add(new Retailer("luksmi",38382939,"luksmi123","Lux","Address12","fax1","+353894855578",new NoPriority("nopriority"),"retailer"));
		users.add(new Retailer("pankaj",48498348,"pankaj123","Punk","Address123","fax12","+432342332",new NoPriority("nopriority"),"retailer"));
		users.add(new Admin("shamitha",3938493,"shamitha123","AdminName123","example@gmail.com",new NoPriority("nopriority"),"admin"));
		
		RuntimeTypeAdapterFactory<User> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
			    .of(User.class, "type")
			    .registerSubtype(Farmer.class, "farmer")
			    .registerSubtype(Admin.class, "admin")
			    .registerSubtype(Retailer.class, "retailer");
		RuntimeTypeAdapterFactory<Priority> runtimeTypeAdapterFactory2 = RuntimeTypeAdapterFactory
			    .of(Priority.class, "priorityType")
			    .registerSubtype(Gold.class, "gold")
			    .registerSubtype(Silver.class, "silver")
			    .registerSubtype(Platinum.class, "platinum")
		        .registerSubtype(NoPriority.class, "nopriority");
		// stamping file
			Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).registerTypeAdapterFactory(runtimeTypeAdapterFactory2).create();

			String json = gson.toJson(users);
			System.out.println( json );
			Type listType = new TypeToken<List<User>>(){}.getType();
			List<User> fromJson = gson.fromJson(json, listType);
	}
	
	public void printMD5s()
	{
		for(User profile : profiles)
		{
			System.out.println( profile.getPassword()+" : "+LoginService.getMD5HashString( profile.getPassword() ) );
		}
	}
}
