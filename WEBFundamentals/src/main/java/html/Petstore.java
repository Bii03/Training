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

	public void writeInfo() throws FileNotFoundException {
		Iterator<Entry<String, JsonNode>> nodeIterator = rootNode.path("info")
				.getFields();
		PrintWriter writer = new PrintWriter(htmlFile);

		writer.append(HTMLUtil.addHTMLBeginning("Pet Store"));

		while (nodeIterator.hasNext()) {
			Map.Entry<String, JsonNode> entry = (Map.Entry<String, JsonNode>) nodeIterator
					.next();
			switch (entry.getKey()) {
				case "title":
					writer.append(HTMLUtil.makeTitle(entry.getValue().asText()));
					break;
				case "description":
					writer.append(HTMLUtil.makeParagraph(entry.getValue().asText()));

			}

		}

		writer.close();

	}

	public void writeAPI() {

	}

}
