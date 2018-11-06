package models.profile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
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
import models.entity.Retailer;
import models.entity.RuntimeTypeAdapterFactory;
import models.entity.User;

public class ProfilesService extends EntityService
{
	public static ProfilesService profilesService;
	List<User> profiles = new ArrayList<>();
	
	static String filePath = "/WEB-INF/db/profile/Profile.json";
	ServletContext context;

	
	private ProfilesService(ServletContext context,String filePath)
	{
		super( context,filePath );
	}
	
	public static ProfilesService getProfileServiceInstance(ServletContext context) throws FileNotFoundException
	{
		if(profilesService == null)
		{
			profilesService = new ProfilesService(context,filePath);
			profilesService.loadEntities();
		}
		return profilesService;
	}
	
	
	
	public void addProfile( User profile )
	{
		profiles.add( profile );
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
		if(user != null && user.getPassword().equals( password ))
		{
			return true;
		}
		else if(user == null)
		{
			return false;
		}
		else if(user != null && !user.getPassword().equals( password ))
		{
			return false;
		}
		return vaild;
	}
	
	
	
	public void loadEntities() throws FileNotFoundException
	{
		super.loadEntities();
//		TypeToken<List<User>> token = new TypeToken<List<User>>() {};
//		profiles = getGson().fromJson(new InputStreamReader(getIs()), token.getType());
//		testGSON();
		RuntimeTypeAdapterFactory<User> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
			    .of(User.class, "type")
			    .registerSubtype(Farmer.class, "farmer")
			    .registerSubtype(Admin.class, "admin")
			    .registerSubtype(Retailer.class, "retailer");
		Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();
		Type listType = new TypeToken<List<User>>(){}.getType();
		profiles = gson.fromJson(new InputStreamReader(getIs()), listType);
	}
	
	public List<User> getUsers()
	{
		return profiles;
	}
	
	public void testGSON()
	{
		List<User> animals = new ArrayList<>();
		animals.add(new Farmer("sulthan","sulthan123","Address1","+353894855578","farmer"));
		animals.add(new Retailer("luksmi","luksmi123","Lux","Address12","fax1","+353894855578","retailer"));
		animals.add(new Retailer("pankaj","pankaj123","Punk","Address123","fax12","+432342332","retailer"));
		animals.add(new Admin("shamitha","shamitha123","AdminName123","example@gmail.com","admin"));
		
		RuntimeTypeAdapterFactory<User> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
			    .of(User.class, "type")
			    .registerSubtype(Farmer.class, "farmer")
			    .registerSubtype(Admin.class, "admin")
			    .registerSubtype(Retailer.class, "retailer");
			Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();

			String json = gson.toJson(animals);
			System.out.println( json );
			Type listType = new TypeToken<List<User>>(){}.getType();
			List<User> fromJson = gson.fromJson(json, listType);
	}
}
