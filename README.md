# PaytmLabs SDE Challenge

## Coding Question

Write an interface for a data structure that can provide the moving average of the last N elements added, add elements to the structure and get access to the elements. Provide an efficient implementation of the interface for the data structure.

### Minimum Requirements

1. Provide a separate interface (IE `interface`/`trait`) with documentation for the data structure
2. Provide an implementation for the interface
3. Provide any additional explanation about the interface and implementation in a README file.

## <span style="color:green"><u>Coding Solution</u></span>

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


## <span style="color:green"><u>Design Solution</u></span>

### High Level System Design/Architecture

Refer to the Google Analytic like Backend System diagram for a high level overview. 

#### Traffic Estimates 

Write: 1 Billion click events per day equates to ~12000 events per second (~ 1B / (24hours * 3600 seconds))
Read/Query: ~1 Million merchants check 5 times per day equates to ~60 events per second ( 5M / (24 hours * 3600 seconds))

### <u>Architecture:</u>

#### Load Balancer:

The HAProxy (High Availability Proxy) Load balancer is used is to improve the performance and reliability of a server environment by distributing the workload across multiple servers. HAProxy routes the requests coming from Web/Mobile Visitor site to the Spring Cloud Gateway of the solution

#### Service Registry and API Gateway

Spring Cloud Gateway is integrated with Netflix Eureka for Service Registry and with Hystri/Resiliency4J for Circuit Breaking. All of these components are well integrated to Spring Boot/Cloud.

#### Microservices 

Spring Boot is utilized for creating Microservices, both for write as well as read operations for the Google Analytic like Backend. Since each service is a separate component, we can scale them independently without scaling the entire application. This makes the microservices extremely scaleable. 
When a failure arises, the at-risk service should still run in a degraded functionality without crashing the entire system. Hystrix Circuit-breaker will come into rescue in such failure scenarios.

We use Kafka Queues to send the write events further downstream.

#### Batch Layer

In this layer, we are using the Kafka Consumer to read from the Queues and add the events to a MongoDB/Cassandra noSQL database to store the data for batch operations to then further ETL transform them and send it to the postGres/mySQL DB for historical data processing. This batch processing also allows us to check if there are any errors due to processing logic.

#### Stream Layer

Apache Spark Streaming is an extension of the core Spark API that enables scalable, high-throughput, fault-tolerant stream processing of live data streams.
In our scenario Spark streaming process Kafka data streams and adds the data to the postGres/mySQL DB for use in the read events. 

#### Merchant View

When a merchant accesses their portal, they go through the Load Balancer to the API Gateway and Service Registry to access the Read Service. 
The Read Service calls the postgreSQL/mySQL tables directly to get the up to date customer analytic data.