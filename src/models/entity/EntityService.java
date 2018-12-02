package models.entity;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Writer;

import javax.servlet.ServletContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EntityService
{
	private Gson gson;
	private Writer writer;
	private String filePath = "";
	private ServletContext context;
	private InputStream is;
	
	public EntityService(ServletContext context,String filePath)
	{
		gson = new GsonBuilder().create();	
		this.context = context;
		this.filePath = filePath;
	}
	
	public void loadEntities() throws FileNotFoundException
	{
		is = context.getResourceAsStream(filePath);		
	}	
	
	public InputStream getIs()
	{
		return is;
	}
	public void setIs( InputStream is )
	{
		this.is = is;
	}
	public Gson getGson()
	{
		return gson;
	}
	public void setGson( Gson gson )
	{
		this.gson = gson;
	}
	public Writer getWriter()
	{
		return writer;
	}
	public void setWriter( Writer writer )
	{
		this.writer = writer;
	}
	public String getFilePath()
	{
		return filePath;
	}
	public void setFilePath( String filePath )
	{
		this.filePath = filePath;
	}
	public ServletContext getContext()
	{
		return context;
	}
	public void setContext( ServletContext context )
	{
		this.context = context;
	}	
	
	
	
	
}
