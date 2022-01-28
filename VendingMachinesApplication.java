package com.dezji.vendingmachines;

import java.util.Scanner;
import static java.lang.System.out;

public class VendingMachinesApplication {

	public static void main(String[] args) {

		// create instances of the object for user to utilize
		GumballMachine gbMachine = new GumballMachine();
		SnackMachine skMachine = new SnackMachine();

		// create scanner object for user input
		Scanner input = new Scanner(System.in);
		
		// welcome message for user
		out.println("Hello! Welcome to the Virtual Vending Machine!");

		// loop for the menu
		while (true) {
			
			// Selection for the user and store the results
			out.println("\nWould you like to vend from the (G)umball machine, or the (S)nack machine? Or would you like to (E)xit?");
			String userInput = input.nextLine();

			// if user chooses this, it pulls up the gumball menu
			if (userInput.toUpperCase().equals("G")) {
				
				// loop for the menu
				while (true) {
					
					// displays the current number of items in the inventory for user reference
					out.println("\nThis machine currently has " + gbMachine.getNumberofItems() + " gumballs.");
					
					// display menu choices
					out.println("(V)end, (R)efill, or (P)revious: ");
						userInput = input.nextLine();

						// vend option
						if (userInput.toUpperCase().equals("V")) {
							out.println(gbMachine.dispense());
						}

						// refill option
						else if (userInput.toUpperCase().equals("R")) {
							out.println("\nWhat is the amount you would like to refill?");
							int amount = input.nextInt();
							input.nextLine();
							gbMachine.refill(amount);
							out.println("\nMachine has been refilled. Machine currently has " + gbMachine.getNumberofItems()
									+ " gumballs in inventory.");
						}

						// previous menu option
						else if (userInput.toUpperCase().equals("P")) {
							break;
						}

						// catches any input errors
						else
							out.println("Invalid choice, please try again.");

					}
				
			} // end of the gumball menu loop

			
			
			// user choice for snack machine
			else if (userInput.toUpperCase().equals("S")) {
				
				// loop for menu
				while (true) {
					
					// displays the current number of items in the inventory for user reference
					out.println("\nThis machine currently has " + skMachine.getNumberofItems() + " snacks.");
					
					// displays the menu choices
					out.println("(V)end, (R)efill, or (P)revious: ");
					userInput = input.nextLine();

					// vend option
					if (userInput.toUpperCase().equals("V")) {
						out.println(skMachine.dispense());
					}

					// refill option
					else if (userInput.toUpperCase().equals("R")) {
						out.println("\nWhat is the amount you would like to refill?");
						int amount = input.nextInt();
						input.nextLine();
						skMachine.refill(amount);
						out.println("\nMachine has been refilled. Machine currently has " + skMachine.getNumberofItems()
								+ " snacks in inventory.");
					}

					// previous menu
					else if (userInput.toUpperCase().equals("P")) {
						break;
					}

					// catch any input errors
					else
						out.println("Invalid choice, please try again.");
				}

			} // end of snack menu loop

			
			// exits the vending machine program
			else if (userInput.toUpperCase().equals("E")) {
				out.println("Thank you for using the Virtual Vending Machine!");
				break;
			}

			// catch any input errors
			else
				out.println("Invalid choice, please try again.");
			
			
		} // end of main menu loop

		input.close();

	}

} // end of main


interface VendingMachine {
	void refill(int count);
	String dispense();
	boolean isEmpty();
}


class GumballMachine implements VendingMachine {

	int productCount = 0;

	@Override
	public void refill(int count) {
		productCount += count;

	}

	@Override
	public String dispense() {
		if (productCount == 0)
			return "Machine is empty, no product dispensed";

		productCount--;

		String color = "";
		switch ((int) (Math.random() * 4)) {
		case 0:
			color = "Red";
			break;
		case 1:
			color = "Yellow";
			break;
		case 2:
			color = "Orange";
			break;
		case 3:
			color = "Green";
			break;
		}
		return "You recieve a " + color.toLowerCase() + " gumball!";
	}

	@Override
	public boolean isEmpty() {
		return productCount == 0;
	}

	public int getNumberofItems() {
		return productCount;
	}

}



class SnackMachine implements VendingMachine {

	int productCount = 0;

	@Override
	public void refill(int count) {
		productCount += count;

	}

	@Override
	public String dispense() {

		if (productCount == 0)
			return "Machine is empty, no product dispensed";

		productCount--;

		String snack = "";
		switch ((int) (Math.random() * 4)) {
		case 0:
			snack = "Chocolate bar";
			break;
		case 1:
			snack = "Soda pop";
			break;
		case 2:
			snack = "Celery stick";
			break;
		case 3:
			snack = "Pack of crackers";
			break;
		}
		return "You recieve a delicious " + snack.toLowerCase() + "!";
	}

	@Override
	public boolean isEmpty() {
		return productCount == 0;
	}

	public int getNumberofItems() {
		return productCount;
	}

}
