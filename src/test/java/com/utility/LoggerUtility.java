package com.utility;



import org.apache.logging.log4j.Logger;


public class LoggerUtility {
	
	
	private LoggerUtility()
	{
		
	}
	public static Logger getLogger(Class<?> clazz)
	{
		 Logger logger= null;/// the purpose this line is every one has their own separate logs
		if(logger==null)
		{
			logger = org.apache.logging.log4j.LogManager.getLogger(clazz);
		}
		return logger;
		
	}

}
