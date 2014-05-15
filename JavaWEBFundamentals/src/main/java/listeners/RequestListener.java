package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import persistence.EmployeeDAO;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
public class RequestListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public RequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent objEvent) {
        // TODO Auto-generated method stub


    	 
        
    }
	
}
