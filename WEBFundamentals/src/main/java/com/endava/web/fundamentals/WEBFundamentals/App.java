package com.endava.web.fundamentals.WEBFundamentals;

import html.Petstore;
import html.SwaggerHTML;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

import entities.Swagger;
import server.ElementaryHTTPServer;
import json.*;

/**
 * Hello world!
 *
 */


public class App 
{
	
	
	
	
	
    public static void main( String[] args ) throws Exception
    {
    	InputStream jsonInputSTream = JSONFromURL.getHTMLFromURL("http://petstore.swagger.wordnik.com/api/api-docs");
    	ObjectMapper mapper = new ObjectMapper();
    	Swagger swagger =  mapper.readValue(jsonInputSTream, Swagger.class);
    	SwaggerHTML html = new SwaggerHTML(swagger, new File("PetStore.html"));
    	
    	synchronized(html){
    		html.writeSwaggerHTML();
    	}
    	
      
    	ElementaryHTTPServer httpServer = new ElementaryHTTPServer(8083);
    	httpServer.start();
  

    	
    }
}
