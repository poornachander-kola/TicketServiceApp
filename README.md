<h2>Ticket Service App</h2>
This App helps is managing seat booking in a Theatre.

<h3>Dependencies</h3>
Java 1.8,
Jersey,
Maven,
JUnit,
Apache Tomcat

<h3>Running the application</h3>
To run the application: 
  Install the above mentioned dependencies
  Clone the project from Github
  Build the application from Command line using mvn commands;
    mvn clean install
  Deploy the war file generated in target folder in tomcat and restart the tomcat.
  
<h3>End point urls to call services:</h3>
<i>http://localhost:8080/TicketServiceApp/TicketServices/availableSeats</i>
Returns integer value - number of availble seats

<i>http://localhost:8080/TicketServiceApp/TicketServices/holdSeats</i>
Takes two inputs int numSeats, String customerEmail - Pass data in json format. returns SeatHold object in Json, contains holdid and seat deatils.

<i>http://localhost:8080/TicketServiceApp/TicketServices/reserveSeats</i>
Takes two inputs String seatHoldId, String customerEmail - Pass data in json format. returns reserveId object in Json

<h3>Testing</h3>
This can be tested in two ways, either by using a postman client to test webservice or build jar from source folder including the jar in test code and call TicektService methods directly.

The has been tested in:
1. Mac, Java 1.8, maven 3.x, jersey 2.24, postman client and Junit.

<h3>Assumptions</h3>
Best seats are assumed to be the first seats in the natural numeric order.
Assumed to set theatre seats to 100, however this can be configured on properties file.
Hold queue has been flused every 60 sec, configurable in real time scenarios.
A seat can be reserved only after if it is currently held.
