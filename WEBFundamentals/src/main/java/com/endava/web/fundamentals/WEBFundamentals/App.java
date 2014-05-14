package com.endava.web.fundamentals.WEBFundamentals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;



import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Hello world!
 *
 */


public class App 
{
	public static StringBuilder getHTMLFromURL(String url) throws ClientProtocolException, IOException{
		HttpClient client = HttpClientBuilder.create().build();
    	HttpGet request = new HttpGet(url);

    	HttpResponse response = client.execute(request);
     
    	System.out.println("Response Code : " 
                    + response.getStatusLine().getStatusCode());
     
    	BufferedReader rd = new BufferedReader(
    		new InputStreamReader(response.getEntity().getContent()));
     
    	StringBuilder result = new StringBuilder();
    	String line = "";
    	while ((line = rd.readLine()) != null) {
    		System.out.println(line);
    		result.append(line);
    		
    	}
    	return result;
	}
	
	public static JsonNode getJSONRoot(File inputFile) throws JsonParseException, JsonMappingException, IOException{
		JsonNode rootNode = null;
		// general method, same as with data binding
		ObjectMapper mapper = new ObjectMapper();
		rootNode = mapper.readTree(inputFile); 
		return rootNode;
	}
	
    public static void main( String[] args ) throws ClientProtocolException, IOException
    {
    	JsonNode root = getJSONRoot(new File("JSONExample.txt"));
    	Iterator<Entry<String, JsonNode>> nodeIterator = root.path("web-app").getFields();
    	
    	while(nodeIterator.hasNext()){
    		Map.Entry<String, JsonNode> entry = (Map.Entry<String, JsonNode>) nodeIterator.next();
    		   System.out.println("key --> " + entry.getKey() + " value-->" + entry.getValue());
    	}
  

    	
    }
}
