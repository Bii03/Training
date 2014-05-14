package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class PetStoreRequestHandler implements HttpRequestHandler{
	
	

	public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext)
			throws HttpException, IOException {
		// TODO Auto-generated method stub
		
		httpResponse.setStatusCode(HttpStatus.SC_OK);
        httpResponse.setHeader("Content-Type", "text/html");
        HttpEntity entity = new FileEntity(new File("PetStore.html"), ContentType.create("text/html", (Charset) null));
        httpResponse.setEntity(entity);
		
	}

}
