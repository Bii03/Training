package listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import domain.Employee;
import persistence.EmployeeDAO;

/**
 * Application Lifecycle Listener implementation class InitializeApp
 *
 */
public class InitializeApp implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InitializeApp() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent objEvent) {
        // TODO Auto-generated method stub
    	 ServletContext objServletContext = objEvent.getServletContext();
    	 objServletContext.setAttribute("welcome", "heloooo!");
         objServletContext.log("Yaaaay, it's working! "+objServletContext.getAttribute("welcome"));
         List<Employee> allEmployees = new ArrayList<Employee>();
         
         try {
			 allEmployees = EmployeeDAO.getAllEmployees();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         objServletContext.setAttribute("employees", allEmployees);
    }
	
}
