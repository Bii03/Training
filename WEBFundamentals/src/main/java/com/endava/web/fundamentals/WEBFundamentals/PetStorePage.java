package com.endava.web.fundamentals.WEBFundamentals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class PetStorePage implements HttpRequestHandler{
	
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
	
	public static JsonNode getJSONRoot(String inputString) throws JsonParseException, JsonMappingException, IOException{
		JsonNode rootNode = null;
		// general method, same as with data binding
		ObjectMapper mapper = new ObjectMapper();
		rootNode = mapper.readTree(inputString); 
		return rootNode;
	}

	public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext)
			throws HttpException, IOException {
		// TODO Auto-generated method stub
		
		httpResponse.setStatusCode(HttpStatus.SC_OK);
        httpResponse.setHeader("Content-Type", "text/plain");
        
        StringBuilder urlHTMLContent = getHTMLFromURL("http://petstore.swagger.wordnik.com/api/api-docs");
        JsonNode rootNode = getJSONRoot(urlHTMLContent.toString());
        
        Iterator<Entry<String, JsonNode>> nodeIterator = rootNode.path("apiVersion").getFields();
        StringBuilder json = new StringBuilder();
    	
    	while(nodeIterator.hasNext()){
    		Map.Entry<String, JsonNode> entry = (Map.Entry<String, JsonNode>) nodeIterator.next();
    		   json.append("key --> " + entry.getKey() + " value-->" + entry.getValue());
    	}
    	System.out.println("JSOOOON " +json.toString());
        
        HttpEntity entity = new StringEntity(json.toString());
        httpResponse.setEntity(entity);
		
	}

}
