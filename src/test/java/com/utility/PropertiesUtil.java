package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static  String readProperty(Env env, String propertyName) {

    System.out.println(System.getProperty("user.dir"));
    File fis=new File(System.getProperty("user.dir")+"\\config\\"+ env +".properties");
    FileReader filereader=null;
    Properties prop=new Properties();
    try {
    		 filereader=new FileReader(fis);
    		prop.load(filereader);
    
    }
    catch(FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch(IOException e )
    {
    	e.printStackTrace();
    }
    String value=prop.getProperty(propertyName.toUpperCase());
    //System.out.println(value);
    return value;
	}
    
	}

