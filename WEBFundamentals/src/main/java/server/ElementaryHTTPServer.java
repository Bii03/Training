package server;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.util.Locale;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;

import org.apache.http.ConnectionClosedException;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpStatus;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.DefaultBHttpServerConnection;
import org.apache.http.impl.DefaultBHttpServerConnectionFactory;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpProcessorBuilder;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.protocol.HttpService;
import org.apache.http.protocol.ResponseConnControl;
import org.apache.http.protocol.ResponseContent;
import org.apache.http.protocol.ResponseDate;
import org.apache.http.protocol.ResponseServer;
import org.apache.http.protocol.UriHttpRequestHandlerMapper;
import org.apache.http.util.EntityUtils;

public class ElementaryHTTPServer {
	
	private int port;
	
	public ElementaryHTTPServer(int port) {
		// TODO Auto-generated constructor stub
		this.port = port;
	}
	 
	
	public void start() throws Exception {

	        // Set up the HTTP protocol processor
	        HttpProcessor httpproc = HttpProcessorBuilder.create()
	                .add(new ResponseDate())
	                .add(new ResponseServer("Test/1.1"))
	                .add(new ResponseContent())
	                .add(new ResponseConnControl()).build();

	        // Set up request handlers
	        UriHttpRequestHandlerMapper reqistry = new UriHttpRequestHandlerMapper();
	        reqistry.register("/", new PetStoreRequestHandler());

	        // Set up the HTTP service
	        HttpService httpService = new HttpService(httpproc, reqistry);


	        Thread t = new RequestListenerThread(port, httpService, null);
	        t.setDaemon(false);
	        t.start();
	    }
	
	
	
	

   

}
