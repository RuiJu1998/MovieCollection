import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.awt.*;
import java.awt.Image.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Launch extends JFrame{
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 720;
	private TypePanel typePanel;
	private JTextArea textArea;
	private Background background;
	private AddMovie addMovie;
	private JLabel yourMovies;
	
	
	public static void main(String[] args) throws SAXException, IOException {
		Launch launch = new Launch();
    	
	}
	
	public Launch() throws SAXException, IOException {
		super("MovieCollection");
		setSize(WIDTH, HEIGHT);
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	background = new Background(); 	
    	background.setLayout(null); 	
    	typePanel = new TypePanel();
        setLayout(new BorderLayout());    
        add(typePanel, BorderLayout.NORTH);
        addMovie = new AddMovie();
        add(addMovie, BorderLayout.WEST);
        textArea = new JTextArea("Null");  
        File file = new File("movieCollection.xml");   
        
        if(file.exists()){
    		if(textArea.getText().equals("Null")) {
        		textArea.setText("");
        	}
        	try {
        		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
            	DocumentBuilder builder;
				builder = factory.newDocumentBuilder();
				Document doc = builder.parse(file);   
				Element root = doc.getDocumentElement();
	        	NodeList nodeList = root.getElementsByTagName("movie");  
	        	for (int i = 0; i < nodeList.getLength(); i++) {   
	        	    textArea.append("Name:"+ doc.getElementsByTagName("name").item(i).getFirstChild().getNodeValue() + "\n");
	        	    textArea.append("Type:"+ doc.getElementsByTagName("type").item(i).getFirstChild().getNodeValue() + "\n");
	        	    textArea.append("Performers:"+ doc.getElementsByTagName("performers").item(i).getFirstChild().getNodeValue() + "\n");
	        	    textArea.append("Release year:"+ doc.getElementsByTagName("release_year").item(i).getFirstChild().getNodeValue() + "\n");
	        	    textArea.append("Your rating:"+ doc.getElementsByTagName("rating").item(i).getFirstChild().getNodeValue() + "\n");
	        	    textArea.append("Your review:"+ doc.getElementsByTagName("review").item(i).getFirstChild().getNodeValue() + "\n");
	        	    textArea.append("\n");
	            }
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}   
        }
        
        textArea.setLineWrap(true);
        JScrollPane textPanel = new JScrollPane(textArea);
        background.add(textPanel);
        textPanel.setBounds(250,30,500,600);
        yourMovies = new JLabel("Your movies:");
        yourMovies.setBounds(150, 5,100,100); 	
        background.add(yourMovies);    
        add(background);
        
        addMovie.setFormListener(new FormListener(){
        	
        	public void formEventOccurred(FormEvent e) {
        		String name = e.getName();
        		String type = e.getType();
        		String performers = e.getPerformers();
        		String releaseYear = e.getReleaseYear();
        		String rating = e.getRating();
        		String review = e.getReview();
        		
        		new CreateXml(name, type, performers, releaseYear, Double.valueOf(rating), review);
        		
        		if(textArea.getText().equals("Null")) {
            		textArea.setText("");
            	}
        		textArea.append("Name: " + name +"\n");
        		textArea.append("Type: " + type +"\n");
        		textArea.append("Performers: " + performers +"\n");
        		textArea.append("Release year: " + releaseYear +"\n");
        		textArea.append("Your rating: " +rating +"\n");
        		textArea.append("Your review: " + review +"\n");
        		textArea.append("\n");
        		

        			

        	
        	}
        });
        
        
        setVisible(true);
        StartFrame startFrame = new StartFrame();
        startFrame.setVisible(true);
	}

	
}
	
	 