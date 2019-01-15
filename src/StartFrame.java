import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StartFrame extends JFrame {
	private JButton start;
	private JTextArea welcomeText;
	
	public StartFrame() {
		
		super("Start");
		setSize(350, 210);
	    setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		welcomeText = new JTextArea("Welcome! This MovieCollection is designed for movie lovers. You can use it to record all the movies you have watched, including your personal ratings and reviews for them.");
        welcomeText.setEditable(false);
        welcomeText.setLineWrap(true);
        welcomeText.setWrapStyleWord(true);
        welcomeText.setMargin(new Insets(10,10,20,20));
        add(welcomeText, BorderLayout.CENTER);
        start = new JButton("Start");
		add(start, BorderLayout.SOUTH);
		start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		
		setVisible(true);
	}
	
	

}
