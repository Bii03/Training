package html;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;

import entities.Swagger;

public class SwaggerHTML {
	
	private Swagger swagger;
	private PrintWriter writer;
	
	
	public SwaggerHTML(Swagger swagger, File outputFile) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		this.swagger = swagger;
		this.writer = new PrintWriter(outputFile);
	}
	
	public void writeSwaggerHTML(){
		
		writer.append(HTMLUtil.addHTMLBeginning("Pet Store"));
		
		writer.append("<div id=\"content\">");
		writer.append(HTMLUtil.makeTitle("Swagger"));
		
		writer.append("<div id=\"description\">");
		writer.append(HTMLUtil.makeParagraph(swagger.getInfo().getDescription()));
		writer.append("</div>");
		writer.append("</div>");
		
		writer.append("<footer>");
		writer.append(HTMLUtil.makeParagraph(swagger.getApiVersion()));
		writer.append("</footer>");
		
		writer.append("</body>");
		writer.append("</html>");
		
		writer.close();
		
		
		
	}

}
