import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class AddMovie extends JPanel{ 	
    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel performersLabel;
    private JLabel releaseYearLabel;
    private JLabel ratingLabel;
    private JLabel reviewLabel;
	private JTextField nameField;
	private JTextField typeField;
	private JTextField performersField;
	private JTextField releaseYearField;
	private JTextField ratingField;
	private JButton okBtn;
	private JTextArea reviewArea;
	private FormListener formListener;
	private JComboBox<String> typeBox;
	    
    public AddMovie() {
    	Dimension dim = getPreferredSize();
    	dim.width = 300;
    	setPreferredSize(dim);
    	nameField = new JTextField(15);
    	performersField = new JTextField(15);
    	releaseYearField = new JTextField(15);
    	ratingField = new JTextField(15);
    	reviewArea = new JTextArea(10,20);
    	reviewArea.setLineWrap(true);
    	typeBox = new JComboBox<String>();
        typeBox.setPreferredSize(new Dimension(190,20));
    	
    	nameLabel = new JLabel("Name:");
    	typeLabel = new JLabel("Type");
    	performersLabel = new JLabel("Performers:");
    	releaseYearLabel = new JLabel("Release year:");
    	ratingLabel = new JLabel("Your rating:");
    	reviewLabel = new JLabel("Your review:");
    	
    	typeBox.addItem("Type");
    	typeBox.addItem("Action");
    	typeBox.addItem("Cartoon");
    	typeBox.addItem("Comedy");
    	typeBox.addItem("Ethics");
    	typeBox.addItem("Horror");
    	typeBox.addItem("Musical");
    	typeBox.addItem("Romance");
    	typeBox.addItem("Science Fiction");
    	typeBox.addItem("Suspense");
    	typeBox.addItem("War");
    	typeBox.addItem("Others");
    	
    	
    	okBtn = new JButton("OK");
        Border innerBorder = BorderFactory.createTitledBorder("Add movie");
        Border  outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gc);
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);   
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(typeLabel, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(typeBox, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(performersLabel, gc);
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(performersField, gc);      
        gc.gridx = 0;
        gc.gridy = 3;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(releaseYearLabel, gc);     
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(releaseYearField, gc);
        gc.gridx = 0;
        gc.gridy = 4;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(ratingLabel, gc);   
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(ratingField, gc); 
        gc.gridx = 0;
        gc.gridy = 5;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(reviewLabel,gc);
        gc.gridheight = 5;
        gc.gridwidth = 2;
        gc.weightx = 1;
        gc.weighty = 2;
        gc.gridx = 0;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(reviewArea), gc);
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 1;
        gc.gridy = 11;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(okBtn, gc);
        
        okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String type = (String)typeBox.getSelectedItem();
				String performers = performersField.getText();
				String releaseYear = releaseYearField.getText();
				String rating = ratingField.getText();
				String review = reviewArea.getText();
				
				if(!name.equals("")) {
					nameField.setText("");
					typeBox.setSelectedIndex(0);
					performersField.setText("");
					releaseYearField.setText("");
					ratingField.setText("");
					reviewArea.setText("");
					
					FormEvent ev = new FormEvent(this, name, type, performers, releaseYear, rating, review);
					if(formListener != null) {
						formListener.formEventOccurred(ev);
					}
				
				}
			}
				
				
			
        });
        
    }

	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}
}
