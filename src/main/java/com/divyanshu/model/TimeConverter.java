package com.divyanshu.model;

public class TimeConverter {

	
	public String print24(String str)
	{
	    // Get hours
	    int h1 = (int)str.charAt(1) - '0';
	    int h2 = (int)str.charAt(0) - '0';
	    int hh = (h2 * 10 + h1 % 10);
	 
	    // If time is in "AM"
	    String result="";
	    if (str.charAt(8) == 'A')
	    {
	        if (hh == 12)
	        {
	            result+="00";
	            for (int i = 2; i <= 7; i++)
	                result+=str.charAt(i);
	        }
	        else
	        {
	            for (int i = 0; i <= 7; i++)
	                result+=str.charAt(i);
	        }
	    }
	 
	    // If time is in "PM"
	    else
	    {
	        if (hh == 12)
	        {
	            result+="12";
	            for (int i = 2; i <= 7; i++)
	                result+=str.charAt(i);
	        }
	        else
	        {
	            hh = hh + 12;
	            result+=Integer.toString(hh);
	            for (int i = 2; i <= 7; i++)
	                result+=str.charAt(i);
	        }
	    }
	    
	    return result;
	}
	
}
