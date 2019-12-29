package com.paytm.sdechallenge;

import java.util.List;
import java.util.Queue;

public interface MovingAverage{

    /**
     * Function to return the elements in the structure.
     * 
     * @return the current size of the structure
     */
    public Queue<Integer> getElementsInStructure();
    
    /**
     * Add an element to the dataStructure.
     *
     * @return boolean with
     *          true :  adding to a new point
     *          false : overwriting an existing point in the data structure
     */
    public boolean addElement(Integer newElement);
    
    /**
     * Function to compute and return the moving average for the data structure
     * 
     * @return the computed moving average
     */
    public Double getMovingAverage();
    
    /**
     * Function to remove the element at position n
     */
    public void removeElement();
}