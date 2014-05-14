package json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONFromURL {
	
	public static InputStream getHTMLFromURL(String url) throws ClientProtocolException, IOException{
		HttpClient client = HttpClientBuilder.create().build();
    	HttpGet request = new HttpGet(url);

    	HttpResponse response = client.execute(request);
     
    	System.out.println("Response Code : " 
                    + response.getStatusLine().getStatusCode());
    	
    	return response.getEntity().getContent();
     
    	

	}

}
