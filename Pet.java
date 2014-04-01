//import statements
import java.util.*;
import javax.swing.*;
/**
  * A class called Pet that represents a pet that we interact with.
  * The pet will have 5 different states.
  *
  *@ Jarred Aultman
  *@ Version 1.0 03/30/2014
  *
  */
  
public class Pet{
	
	enum State {SLEEPING, EATING, DEAD, LAUGHING, NORMAL}
	private State status;
	private int hunger;
	private final int FULL = 10;

	private ImageIcon icon1, icon2, icon3, icon4, icon5, image;
	
	/**
	  * A constructor that sets the initial state to a normal state.
	  * It sets hunger to the full and instantiate all the ImageIcon instance variables.
	  *
	  */
	public Pet() {
		this.status = State.NORMAL;
		this.hunger = 10;
		this.icon1 = new ImageIcon("src/dead.png");
		this.icon2 = new ImageIcon("src/eating.png");
		this.icon3 = new ImageIcon("src/laughing.png");
		this.icon4 = new ImageIcon("src/normal.png");
		this.icon5 = new ImageIcon("src/sleeping.png");
		image = new ImageIcon();
	}
	/**
	  * A getter method to get the hunger instance variable.
	  *
	  */
	public int getHunger(){
		return this.hunger;
	}
	/**
	  * A getter method to get the status instance variable.
	  *
	  */
	public State getStatus(){
		return this.status;
	}
	/**
	  * A method that returns the ImageIcon of the corresponding current state 
	  * of the pet.
	  * @return The image icon that corresponds with the status
	  */
	public ImageIcon getCurrentIcon(){
		if (getStatus() == State.DEAD)
			image = icon1;
		if (getStatus() == State.EATING)
			image =  icon2;
		if (getStatus() == State.LAUGHING)
			image = icon3;
		if (getStatus() == State.NORMAL)
			image = icon4;
		if (getStatus() == State.SLEEPING)
			image = icon5;
		return image;
	}
	/**
	  * A method that sets the state of the pet to laughing.
	  *
	  */
	public void poke(){
		if(getStatus() != State.DEAD){
			this.status = State.LAUGHING;
			this.hunger = hunger - 1;
		}
		checkForStarvation();
		
	}
	/**
	  * A method that sets the state of the pet to eating and resets
	  * hunger to zero.
	  */
	public void feed(){
		if(getStatus() != State.DEAD){
		
			if (getStatus() == State.EATING)
				this.status = State.DEAD;
			else{
				this.status = State.EATING;
				this.hunger = FULL;
			}
			
		}
	}
	/**
	  * A method that sets the state to sleep.
	  */
	public void sleep(){
	if (getStatus() != State.DEAD)
		status = State.SLEEPING;
	}
	/**
	  * A method that sets the state to normal.
	  *
	  */
	public void sit(){
		if (getStatus() != State.DEAD){

			status = State.NORMAL;
			hunger = hunger - 1;
			checkForStarvation();
			
		}
	}
	/**
	  * A method that randomly calls the poke, sleep, and sit methods.
	  *
	  */
	public void watch(){
		Random gen = new Random();
		int num1 = gen.nextInt(3);
		if (num1 == 0)
			sit();
		if (num1 == 1)
			poke();
		if (num1 == 2)
			sleep();
		
	}
	/**
	  * A method that sets the state of the pet to dead.
	  */
	public void kill(){
		this.status = State.DEAD;
	}
	/**
	  * A method that checks to see if the hunger value is zero.
	  * If it is, it sets the state of the pet to dead.
	  *
	  */
	public void checkForStarvation(){
		if (hunger == 0)
			this.status = State.DEAD;
	}
	/**
	 * A method that checks to see if the pet is dead 
	 * @return boolen object
	 */
	public boolean checkForDead(){
		if(getStatus() == State.DEAD)
			return true;
		return false;
	}
	/**
	 * A method that resets the state of the pet to normal and full hunger.
	 */
	public void reset(){
		this.status = State.NORMAL;
		this.hunger = FULL;
	}

}