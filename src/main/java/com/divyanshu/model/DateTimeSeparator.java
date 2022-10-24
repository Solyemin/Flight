package com.divyanshu.model;

public class DateTimeSeparator {
  //this method will separate the date and time , 
	//takes date in format dd/mm/yyyy and time in format hh:mm AM/PM .
	//It must return the date in format yyyy-mm-dd and time in format hh:mm:ss
	
	public String[] DateTimeMySqlFormat(String datetime,String resultDate,String resultTime)
	{
		
		if(datetime.length()==18)
			{
			 datetime=datetime.substring(0,11)+"0"+datetime.substring(11);
			 System.out.println("here inside datetimeseparator"+datetime);
			}
		
		String date=datetime.substring(0,10);//gives the date in format dd/mm/yyyy
		String time=datetime.substring(11,16);//get the time 
		time=time+":00"+datetime.substring(17,19);
		String result[]=new String[2];
		
		String dd,mm,yyyy;
		mm=date.substring(0,2);
		dd=date.substring(3,5);
		yyyy=date.substring(6,10);
		resultDate=dd+"/"+mm+"/"+yyyy;
		resultTime=new TimeConverter().print24(time);
		
		result[0]=new String(resultDate);
		result[1]=new String(resultTime);
		
		
		System.out.println("ResultDate:"+resultDate+"\nResultTime:"+resultTime);
		System.out.println("DateTimeSeparator is running just fine !");
		return result;
	}

	
}

