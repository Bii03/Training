package html;

public class HTMLUtil {

	public static String makeTitle(String title){
		return "<h1>"+title+"</h1>";
	}
	
	public static String addHTMLBeginning(String title){
		StringBuilder html = new StringBuilder();
		html.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">")
			.append("<html>")
			.append("<head>")
			.append("<title>")
			.append(title)
			.append("</title>")
			.append("</head>")
			.append("<body>");
		
		return html.toString();
			
	}
	
	public static String makeParagraph(String text){
		String[] lines = text.split("\n");
		
		StringBuilder html = new StringBuilder();
		html.append("<p>");
		
		for(String line: lines){
			html.append(line);
			html.append("<br>");
		}
		
		html.append("</p>");
		
		return html.toString();
	}
}
