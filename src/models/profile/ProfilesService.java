package models.profile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import models.entity.EntityService;
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
	
	public void loadEntities() throws FileNotFoundException
	{
		super.loadEntities();
		TypeToken<List<User>> token = new TypeToken<List<User>>() {};
		List<User> users = getGson().fromJson(new InputStreamReader(getIs()), token.getType());

	}
}
