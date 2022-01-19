# Weather
A Spring Boot application that reads in the weather data, filters out that data and sends that object to AWS SNS service 
Weather data can be generated from http://mocker.egen.academy/

Version 0.1
  - Designed the application using MVC architecture
  - Created a Weather model and Wind Model to store data in a local database
  - Made it a RESTFul service
  - Controller accepts the data at http://localhost:8080/weather/addData
  - Controller return a sorted weather list at http://localhost:8080/weather/getDataSortedByCity

Version 0.2
  - Implemented a Rest Templates that posts data to "http://localhost:8081/weatherAlert/addData"
