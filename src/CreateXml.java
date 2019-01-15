import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.*;

public class CreateXml {
	private File file = new File("movieCollection.xml");
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder db;
	private Document document;
	private Element movieCollectionElement;
	private Element movieElement;
	private Element nameElement;
	private Element typeElement;
	private Element performersElement;
	private Element releaseYearElement;
	private Element ratingElement;
	private Element reviewElement;
	private Transformer tf;
	
	public CreateXml(String name, String type, String performers, String releaseYear, Double rating, String review) {
		try {
			db = factory.newDocumentBuilder();
			if(!file.exists()) {
				document =  db.newDocument();
				movieCollectionElement= document.createElement("MovieCollection");
				document.appendChild(movieCollectionElement);
				movieElement = document.createElement("movie");
				movieCollectionElement.appendChild(movieElement);
				
			}else {
				document = db.parse(file);
				movieElement = document.createElement("movie");
				document.getDocumentElement().appendChild(movieElement);
			}
			nameElement = document.createElement("name");
			typeElement = document.createElement("type");
		    performersElement = document.createElement("performers");
			releaseYearElement = document.createElement("release_year");
			ratingElement = document.createElement("rating");
			reviewElement = document.createElement("review");
			document.setXmlStandalone(true);
			nameElement.setTextContent(name);
			typeElement.setTextContent(type);
			performersElement.setTextContent(performers);
			releaseYearElement.setTextContent(releaseYear);
			ratingElement.setTextContent(Double.toString(rating));
			reviewElement.setTextContent(review);
			movieElement.appendChild(nameElement);
			movieElement.appendChild(typeElement);
			movieElement.appendChild(performersElement);
			movieElement.appendChild(releaseYearElement);
			movieElement.appendChild(ratingElement);
			movieElement.appendChild(reviewElement);
			tf = TransformerFactory.newInstance().newTransformer();
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); 
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream(file)));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	


}
