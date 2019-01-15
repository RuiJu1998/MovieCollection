import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TypeFrame extends JFrame{
	private JButton sortByName, sortByRating;
	private JTextArea textArea;
	private JPanel sortPanel;
	private TreeMap<String, Movie> movieMap;
	private Movie movie;
	
	public TypeFrame(String type) {
		super(type);
		setSize(800, 700);
	    setLocationRelativeTo(null);
		sortByName = new JButton("Sort by name");
		sortByRating = new JButton("Sort by rating");
		sortPanel = new JPanel();
		textArea = new JTextArea("Null");
		textArea.setLineWrap(true);
		sortPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		File file = new File("movieCollection.xml"); 
		if(file.exists()) {
			if(textArea.getText().equals("Null")) {
				textArea.setText("");
			}
			try {
				
	        	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
	        	DocumentBuilder builder = factory.newDocumentBuilder();   
	        	Document doc = builder.parse(file);   
	        	Element root = doc.getDocumentElement();
	        	NodeList nodeList = root.getElementsByTagName("movie");  
	        	movieMap= new TreeMap<String, Movie>();
	        	for (int i = 0; i < nodeList.getLength(); i++) { 
	        		
	        		if(doc.getElementsByTagName("type").item(i).getFirstChild().getNodeValue().equals(type)){
	        			String nameElement = doc.getElementsByTagName("name").item(i).getFirstChild().getNodeValue();
	        			String typeElement = doc.getElementsByTagName("type").item(i).getFirstChild().getNodeValue();
	        			String performersElement = doc.getElementsByTagName("performers").item(i).getFirstChild().getNodeValue();
	        			String releaseYearElement = doc.getElementsByTagName("release_year").item(i).getFirstChild().getNodeValue();
	        			String ratingElement = doc.getElementsByTagName("rating").item(i).getFirstChild().getNodeValue();
	        			String reviewElement = doc.getElementsByTagName("review").item(i).getFirstChild().getNodeValue();
	        			movie = new Movie(nameElement, typeElement, performersElement, Integer.valueOf(releaseYearElement), Double.valueOf(ratingElement), reviewElement);
	        			movieMap.put(nameElement + "_" + releaseYearElement, movie);
	        			textArea.append("Name:"+ nameElement + "\n");
		        	    textArea.append("Type:"+ typeElement + "\n");
		        	    textArea.append("Performers:"+ performersElement + "\n");
		        	    textArea.append("Release year:"+ releaseYearElement + "\n");
		        	    textArea.append("Your rating:"+ ratingElement + "\n");
		        	    textArea.append("Your review:"+ reviewElement + "\n");
		        	    textArea.append("\n");
	        		}
	        	}   
		        	
		    } catch (Exception e) {   
		        	e.printStackTrace();   
		    }   
			if(textArea.getText().equals("")) {
				textArea.append("Null");
			}
			 
		}
		
		sortPanel.add(sortByName);
		sortPanel.add(sortByRating);
		setLayout(new BorderLayout());
		add(sortPanel, BorderLayout.NORTH);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		
		
		sortByName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!textArea.getText().equals("Null")) {
				    textArea.setText("");
				    for(Entry<String, Movie> aEntry:movieMap.entrySet()) {
				    	textArea.append("Name:" + aEntry.getValue().name + "\n");
				    	textArea.append("Type:" + aEntry.getValue().type + "\n");
				    	textArea.append("Performers:" + aEntry.getValue().performers + "\n");
				    	textArea.append("Release year:" + aEntry.getValue().releaseYear + "\n");
				    	textArea.append("Your rating:" + aEntry.getValue().rating + "\n");
				    	textArea.append("Your review:" + aEntry.getValue().review + "\n");
				    	textArea.append("\n");
			        }
				    
				}
				
			}
		});
		
		
		sortByRating.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!textArea.getText().equals("Null")) {
				    textArea.setText("");
				    List<Entry<Integer, Movie>> list =new ArrayList<Entry<Integer, Movie>>((Collection<? extends Entry<Integer, Movie>>) movieMap.entrySet());
			        Collections.sort(list, new Comparator<Entry<Integer, Movie>>() {
			            @Override
			            public int compare(Entry<Integer, Movie> o1, Entry<Integer, Movie> o2) {
			                return o2.getValue().rating.compareTo(o1.getValue().rating);
			            }
			        });
			        for(Entry<Integer, Movie> aEntry:list) {
				    	textArea.append("Name:" + aEntry.getValue().name + "\n");
				    	textArea.append("Type:" + aEntry.getValue().type + "\n");
				    	textArea.append("Performers:" + aEntry.getValue().performers + "\n");
				    	textArea.append("Release year:" + aEntry.getValue().releaseYear + "\n");
				    	textArea.append("Your rating:" + aEntry.getValue().rating + "\n");
				    	textArea.append("Your review:" + aEntry.getValue().review + "\n");
				    	textArea.append("\n");
			        }
				    
				}
				
			}
		});
		setVisible(true);
		
	}
}
