import javax.swing.*;

/**
  * A class with a main method that creates a JFrame and brings together a
  * Pet object and the PetPanel object.
  * 
  *@ Jarred Aultman
  *@ Version 1.0 03/30/2014
  */
public class PetMain{
	
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame ("Pet Pal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Pet pet2 = new Pet();
		
		PetPanel panel = new PetPanel(pet2);
		
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
	
	}

}