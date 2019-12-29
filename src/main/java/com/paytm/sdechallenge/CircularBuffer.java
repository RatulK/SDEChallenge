package com.paytm.sdechallenge;

import java.util.LinkedList;
import java.util.Queue;

public class CircularBuffer implements MovingAverage {
	
	private Queue<Integer> structure = new LinkedList<>();
	
	private int capacity = 0;
	private double sum = 0.0;
	
	public CircularBuffer(Integer n) {
		if(n <= 0) {
			System.out.println("Buffer Size must be positive.");
			System.exit(0);
		}
			
		capacity = n;
	}

	@Override
	public boolean addElement(Integer newElement) {
		
		sum += newElement;
		structure.add(newElement);
		
		if(structure.size() > capacity)
			sum -= structure.remove();
		
		return false;
	}
	
	@Override
	public Double getMovingAverage(){
		if(structure.isEmpty())
			return 0.0;
		
		return sum/structure.size();
	}

	@Override
	public Queue<Integer> getElementsInStructure() {
		return structure;
	}

	@Override
	public void removeElement() {
		sum -= structure.remove();
	}


}