package ch11;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;


public class ListenerExam implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {

    //ServletContext 시작
    public void contextInitialized(ServletContextEvent sce)  { 
        sce.getServletContext().log("##### ServletContext 시작됨!!");
    }
    //ServletContext 종료
    public void contextDestroyed(ServletContextEvent sce)  { 
    	sce.getServletContext().log("##### ServletContext 종료됨!!");
    }
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	scae.getServletContext().log("##### ServletContext 속성 추가: " + scae.getValue());
    }
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
        
    }
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         
    }
    //##################################################

	

    public void sessionCreated(HttpSessionEvent se)  { 
         
    }
    public void sessionDestroyed(HttpSessionEvent se)  { 
         
    }
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
        
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	se.getSession().getServletContext().log("##### Session 속성 추가: " + se.getValue());
    }
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
        
    }

	


	
}
