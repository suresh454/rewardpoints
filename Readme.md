# Rewards Points Project.
This project calculates you the rewards points awarding to the customer based on the purchase made.

# Accessing Service
You can access this service bringing up the spring boot application.
1. mvn clean install
2. mvn spring-boot:run

This brings the application in localhost:8080/rewards

# Accessing service in postman
1. Create request in postman with http://localhost:8080/rewards/<totalBill>
2. Working request:
    ! [proper request] (properrequest.png)
3. Exception Request: 
   1. ![Error request] (Error.png)