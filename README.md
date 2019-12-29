# PaytmLabs SDE Challenge

## Coding Question

Write an interface for a data structure that can provide the moving average of the last N elements added, add elements to the structure and get access to the elements. Provide an efficient implementation of the interface for the data structure.

### Minimum Requirements

1. Provide a separate interface (IE `interface`/`trait`) with documentation for the data structure
2. Provide an implementation for the interface
3. Provide any additional explanation about the interface and implementation in a README file.

## Coding Solution

I have implemented a Circular Buffer which allows the user, given a buffer size, to get the moving average of the structure. 
The Circular Buffer uses a Queue as the base structure to keep track of the elements being added. Once we have reached the buffer limit, 
the queue starts removing elements from the head of the queue and inserting at the tail to keep our moving window. 
The sum of the existing numbers in the window is saved and on every call to movingAverage(), the average is calculated and returned.

I have implemented a Menu to show an example of how to run the program and see the implementation with some basic validations included. 

Run the SDEChallenge as a Java Application and follow the menu prompts to see the implementation of the project.

## Design Question

Design A Google Analytic like Backend System.
We need to provide Google Analytic like services to our customers. Please provide a high level solution design for the backend system. Feel free to choose any open source tools as you want.

### Requirements

1. Handle large write volume: Billions of write events per day.
2. Handle large read/query volume: Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
3. Provide metrics to customers with at most one hour delay.
4. Run with minimum downtime.
5. Have the ability to reprocess historical data in case of bugs in the processing logic.
