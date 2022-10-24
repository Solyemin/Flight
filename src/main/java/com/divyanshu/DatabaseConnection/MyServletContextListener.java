package com.divyanshu.DatabaseConnection;

import javax.servlet.ServletContext;  
import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;  
public class MyServletContextListener implements ServletContextListener{  
      public void contextInitialized(ServletContextEvent event)  
      {  
            ServletContext context=event.getServletContext();  
            String url=context.getInitParameter("URL");  
//            String database=context.getInitParameter("Database name");  
            String username=context.getInitParameter("Username");  
            String password=context.getInitParameter("password");  
            MyDatabase mydb=new MyDatabase(url,username,password);
            MyDatabase mydb2=new MyDatabase(url+"useSSL=false",username,password);
            context.setAttribute("Database", mydb);  
            context.setAttribute("DatabaseSSLFalse", mydb2);
      }  
      public void contextDestroyed(ServletContextEvent event)  
      {  
    	  
      }  
}  