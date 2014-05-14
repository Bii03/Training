package com.endava.web.fundamentals.WEBFundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClientProtocolException, IOException
    {
    	String url = "http://www.google.com/search?q=httpClient";
    	 
    	HttpClient client = HttpClientBuilder.create().build();
    	HttpGet request = new HttpGet(url);
     
    	// add request header
    	//request.addHeader("User-Agent", USER_AGENT);
    	HttpResponse response = client.execute(request);
     
    	System.out.println("Response Code : " 
                    + response.getStatusLine().getStatusCode());
     
    	BufferedReader rd = new BufferedReader(
    		new InputStreamReader(response.getEntity().getContent()));
     
    	StringBuffer result = new StringBuffer();
    	String line = "";
    	while ((line = rd.readLine()) != null) {
    		result.append(line);
    	}
    	System.out.println(result);
    }
}
