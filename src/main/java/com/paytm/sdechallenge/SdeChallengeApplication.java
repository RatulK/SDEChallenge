package com.paytm.sdechallenge;

import java.util.Scanner;

public class SdeChallengeApplication {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Circular Buffer\n");
        System.out.print("Enter Size of Buffer: ");
        int bufferCapacity = scanner.nextInt();
        
        CircularBuffer circularBuffer = new CircularBuffer(bufferCapacity);
        char cont;
        
		do {
			System.out.println("\nCircular Buffer Operations");
            System.out.println("1. Add an element to the Structure");
            System.out.println("2. Remove First Element from Structure");
            
            int choice = scanner.nextInt();
            
            switch(choice) {
            
            case 1:
            	System.out.print("Element to be added: ");
            	int newElement = scanner.nextInt();
            	circularBuffer.addElement(newElement);
            	break;
            	
            case 2:
            	circularBuffer.removeElement();
            	break;
            	
        	default:
	        	System.out.println("Option not found.");
	        	break;
            }

        	System.out.print("\nElements in Structure now: ");
        	circularBuffer.getElementsInStructure().forEach(item -> System.out.print(item + " "));
        	
            System.out.print("\nRunning average is: " + circularBuffer.getMovingAverage() + "\n");
        	
			System.out.print("\nDo you want to continue (Type y or n): ");
			cont = scanner.next().charAt(0);
 
        } while (cont == 'Y'|| cont == 'y'); 
		
		scanner.close();
	}

}
