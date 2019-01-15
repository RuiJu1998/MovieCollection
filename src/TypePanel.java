import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TypePanel extends JPanel{
	private JButton action;
	private JButton cartoon;
	private JButton comedy;
	private JButton ethics;
	private JButton horror;
	private JButton musical;
	private JButton romance;
	private JButton scienceFiction;
	private JButton suspense;
	private JButton war;
	private JButton others;
	
	public TypePanel() {
		setOpaque(false);
		action = new JButton("Action");
		cartoon = new JButton("Cartoon");
		comedy = new JButton("Comedy");
		ethics = new JButton("Ethics");
		horror = new JButton("Horror");
		musical = new JButton("Musical");
		romance = new JButton("Romance");
		scienceFiction = new JButton("Science Fiction");
		suspense = new JButton("Suspense");
		war = new JButton("War");
		others = new JButton("Others");
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(action);
		add(cartoon);
		add(comedy);
		add(ethics);
		add(horror);
		add(musical);
		add(romance);
		add(scienceFiction);
		add(suspense);
		add(war);
		add(others);
		
		action.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TypeFrame("Action");
			}
		
		});
		
		cartoon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TypeFrame("Cartoon");
			}
		
		});
		
		comedy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TypeFrame("Comedy");
			}
		
		});
		
		ethics.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TypeFrame("Ethics");
			}
		
		});
		
		horror.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TypeFrame("Horror");
			}
		
		});
		
		musical.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TypeFrame("Musical");
			}
		
		});
		
		romance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TypeFrame("Romance");
			}
		
		});
		
		scienceFiction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TypeFrame("Science Fiction");
			}
		
		});
		
		suspense.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TypeFrame("Suspense");
			}
		
		});
		
		war.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TypeFrame("War");
			}
		
		});
		
		others.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TypeFrame("Others");
			}
		
		});
	}
}
