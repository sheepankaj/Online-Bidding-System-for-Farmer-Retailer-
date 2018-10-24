package models.profile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ProfilesService
{
	public static ProfilesService profilesService;
	List<Profile> profiles;
	Gson gson;
	Writer writer;
	
	private ProfilesService()
	{
		gson = new GsonBuilder().create();		
	}
	
	public static ProfilesService getProfileServiceInstance() throws FileNotFoundException
	{
		if(profilesService == null)
		{
			profilesService = new ProfilesService();
			profilesService.loadProfiles();			
		}
		return profilesService;
	}
	
	public void saveProfilesList() throws IOException
	{
		if(writer == null)
        {
        	writer = new FileWriter("Output.json");
        }
		gson.toJson(profiles, writer);
		writer.close();
	}
	
	public void addProfile( Profile profile )
	{
		profiles.add( profile );
	}
	
	public Profile getProfile( String username )
	{
		for(Profile profile : profiles)
		{
			if(profile.getUsername().equals( username ))
			{
				return profile;
			}
		}
		return null;
	}
	
	public boolean validLogin(String username, String password)
	{
		
	}
	
	public void loadProfiles() throws FileNotFoundException
	{
		//List<Profile> profiles = gson.fromJson(new FileReader("D:\\file.json"), List<Profile>.class);
		TypeToken<List<Profile>> token = new TypeToken<List<Profile>>() {};
		List<Profile> animals = gson.fromJson(new FileReader("Output.json"), token.getType());

	}
}
