package com.d_blaze.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
  Properties prop;
	
  public Readconfig() {
		File src = new File("./Configuation/config.properties");
		
		try {
			FileInputStream fls = new FileInputStream(src);
		    prop = new Properties();
		    prop.load(fls);
		}
		catch(Exception e) {
			System.out.println("Exception"+ e.getMessage());
		}
	}
	
	public String getApplicationURL()
	  {
		   String url = prop.getProperty("baseURL");
		   return url;
	  }
	  public String getUserName()
	  {
		  String Uname = prop.getProperty("username");
		  return Uname;
	  }
	  public String getPassword()
	  {
		  String Pwd = prop.getProperty("password");
		  return Pwd;
	  }
	  
	/*  public String getUname() {
		String nm = prop.getProperty("name");
		return nm;
	}
	  public String getUcountry() {
			String ct = prop.getProperty("country");
			return ct;
		}
	  public String getUcity() {
			String cy = prop.getProperty("city");
			return cy;
		}
	  public String getUcard() {
			String cd = prop.getProperty("card");
			return cd;
		}
	  public String getUmon() {
			String mt= prop.getProperty("month");
			return mt;
		}
	  public String getUyr() {
			String yr = prop.getProperty("year");
			return yr;
		}
	 
	  public String getCname() {
		  String cn = prop.getProperty("contname");
		  return cn;
	}
	  public String getCmesg() {
		  String cmg = prop.getProperty("cmesg");
		  return cmg;
	  }*/

}
