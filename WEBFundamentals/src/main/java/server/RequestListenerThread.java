package server;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLServerSocketFactory;

import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.DefaultBHttpServerConnection;
import org.apache.http.impl.DefaultBHttpServerConnectionFactory;
import org.apache.http.protocol.HttpService;



public class RequestListenerThread extends Thread{
	
    private final HttpConnectionFactory<DefaultBHttpServerConnection> connFactory;
    private final ServerSocket serversocket;
    private final HttpService httpService;
    
    public RequestListenerThread(
            final int port,
            final HttpService httpService,
            final SSLServerSocketFactory sf) throws IOException {
    	
        this.connFactory = DefaultBHttpServerConnectionFactory.INSTANCE;
        this.serversocket = sf != null ? sf.createServerSocket(port) : new ServerSocket(port);
        this.httpService = httpService;
    }
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 System.out.println("Listening on port " + this.serversocket.getLocalPort());
         while (!Thread.interrupted()) {
             try {
                 // Set up HTTP connection
                 Socket socket = this.serversocket.accept();
                 System.out.println("Incoming connection from " + socket.getInetAddress());
                 HttpServerConnection conn = this.connFactory.createConnection(socket);

                 // Start worker thread
                 Thread t = new WorkerThread(this.httpService, conn);
                 t.setDaemon(true);
                 t.start();
             } catch (InterruptedIOException ex) {
                 break;
             } catch (IOException e) {
                 System.err.println("I/O error initialising connection thread: "
                         + e.getMessage());
                 break;
             }
         }
	}

}
