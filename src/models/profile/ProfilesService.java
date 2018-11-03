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

import models.entity.User;

public class ProfilesService
{
	public static ProfilesService profilesService;
	List<User> profiles = new ArrayList<>();
	Gson gson;
	Writer writer;
	String filePath = "/WEB-INF/db/profile/Profile.json";
	ServletContext context;

	
	private ProfilesService()
	{
		gson = new GsonBuilder().create();		
	}
	
	public static ProfilesService getProfileServiceInstance(ServletContext context) throws FileNotFoundException
	{
		if(profilesService == null)
		{
			profilesService = new ProfilesService();
			profilesService.context = context;
			profilesService.loadProfiles();
		}
		return profilesService;
	}
	
	public void saveProfilesList() throws IOException
	{
		if(writer == null)
        {
        	writer = new FileWriter("Profile.json");
        }
		gson.toJson(profiles, writer);
		writer.close();
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
		User profile = getProfile( username );
		if(profile != null && profile.getPassword().equals( password ))
		{
			return "{\"state\":\"Success\",\"message\":\"Login Successfull..!!\"}";
		}
		else if(profile == null)
		{
			return "{\"state\":\"Failed\",\"message\":\"Username not found..!\"}";
		}
		else if(profile != null && !profile.getPassword().equals( password ))
		{
			return "{\"state\":\"Failed\",\"message\":\"Password incorrect!\"}";
		}
		return "{\"state\":\"Failed\",\"message\":\"Unknown Error..!\"}";
	}
	
	public void loadProfiles() throws FileNotFoundException
	{
		//List<Profile> profiles = gson.fromJson(new FileReader("D:\\file.json"), List<Profile>.class);
		InputStream is = context.getResourceAsStream(filePath);
		TypeToken<List<User>> token = new TypeToken<List<User>>() {};
		List<User> profiles = gson.fromJson(new InputStreamReader(is), token.getType());

	}
}
