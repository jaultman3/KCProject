

import java.awt.event.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
  * A class that extends JPanel and displays the pet and provides
  * a picture of the pet and instance variables for the buttons.
  *
  *@ Jarred Aultman
  *@ Version 1.0 03/30/2014
  *
  */
public class PetPanel extends JPanel {
	
	private Pet pet1;
	private JLabel hungerLabel;
	private JLabel picLabel;
	private JButton feed, poke, watch, kill;
	/**
	  * A constructor that takes in a Pet parameter and stores it into 
	  * the instance variable. It sets the size of the PetPanel, instantiates
	  * the JLabels and buttons. It also adds the labels, buttons, and action listeners.
	  * @param Pet object
	  *
	  */
	public PetPanel(Pet petpan){
		pet1 = petpan;
		
		hungerLabel = new JLabel("Hunger: " + pet1.getHunger());
		picLabel = new JLabel(pet1.getCurrentIcon());
		
		feed = new JButton("Feed");
		poke = new JButton("Poke");
		watch = new JButton("Watch");
		kill = new JButton("Kill");
		
		setPreferredSize (new Dimension(210, 300));
		add(hungerLabel);
		add(picLabel);
		add(feed);
		add(poke);
		add(watch);
		add(kill);
		feed.addActionListener(new ButtonListener());
		poke.addActionListener(new ButtonListener());
		watch.addActionListener(new ButtonListener());
		kill.addActionListener(new ButtonListener());
	
	}
	/**
	  * A method that updates the pet label and updates the hunger label the their respective
	  * current status.
	  *
	  */
	public void refresh(){
		hungerLabel.setText("Hunger: " + pet1.getHunger());
		picLabel.setIcon(pet1.getCurrentIcon());
		
	}
	/**
	  * A method that produces a pop up dialog box asking the user to create another PetPal after the
	  * current dies.
	  *
	  */
	public void optionPaneKill(){
		int result = JOptionPane.showConfirmDialog(null,"You killed your PetPal! Start a new PetPal?", null, JOptionPane.YES_NO_OPTION); 
		if(result == JOptionPane.YES_OPTION) {
		    if(pet1.checkForDead())
		    	pet1.reset();
		}
		else
			System.exit(0);
	}
	/**
	  * A method that produces a pop up dialog box asking the user to create another PetPal after the
	  * current dies.
	  *
	  */
	public void optionPaneNeglect(){
		int result = JOptionPane.showConfirmDialog(null,"Your PetPal died from starvation! Start a new PetPal?", null, JOptionPane.YES_NO_OPTION); 
		if(result == JOptionPane.YES_OPTION) {
		    if(pet1.checkForDead())
		    	pet1.reset();
		}
		else
			System.exit(0);
	}
	/**
	  * A method that produces a pop up dialog box asking the user to create another PetPal after the
	  * current dies.
	  *
	  */
	public void optionPaneOverfed(){
		int result = JOptionPane.showConfirmDialog(null,"Your PetPal died from eating too much! Start a new PetPal?", null, JOptionPane.YES_NO_OPTION); 
		if(result == JOptionPane.YES_OPTION) {
			pet1.reset();
		}
		else
			System.exit(0);
	}
	/**
	  * An ActionListener that handles what happens when each button is clicked. 
	  *
	  */
	private class ButtonListener implements ActionListener{
		/**
	  	  * A method that assigns each button an event.
		  *
		  */
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == feed){
				pet1.feed();
				picLabel.setIcon(pet1.getCurrentIcon());
				if(pet1.checkForDead())
					optionPaneOverfed();
			}
			if(event.getSource() == poke){
				pet1.poke();
				picLabel.setIcon(pet1.getCurrentIcon());
				if(pet1.checkForDead())
					optionPaneNeglect();
			}
			if(event.getSource() == watch){
				pet1.watch();
				picLabel.setIcon(pet1.getCurrentIcon());
				if(pet1.checkForDead())
					optionPaneNeglect();
			}
			if(event.getSource() == kill){
				pet1.kill();
				picLabel.setIcon(pet1.getCurrentIcon());
				optionPaneKill();
			}
			refresh();		
		}
	}

}