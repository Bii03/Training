package html;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;

public class Petstore {
	
	JsonNode rootNode;
	File htmlFile;

	public Petstore(JsonNode rootNode, File htmlFile) {
		super();
		this.rootNode = rootNode;
		this.htmlFile = htmlFile;
	}
	
	public void writeInfo() throws FileNotFoundException{
		Iterator<Entry<String, JsonNode>> nodeIterator = rootNode.path("info").getFields();
        PrintWriter writer = new PrintWriter(htmlFile);
        
        writer.append("<html> <head> <title> PetStore</title></head><body>");
    	
    	while(nodeIterator.hasNext()){
    		Map.Entry<String, JsonNode> entry = (Map.Entry<String, JsonNode>) nodeIterator.next();
    		   if(entry.getKey().equals("title")){
    			   writer.append("<h1>"+entry.getValue()+"</h1>");
    		   }
    	}
    	
    	writer.close();

	}
	
	public void writeAPI(){
		
	}
	
	
}
