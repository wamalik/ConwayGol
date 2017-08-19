# ConwayGol
Application can be executed using following two methods
* To run the application on stand-alone tomcat, please build/package the project by executing following command
```
mvn clean package
```
This would create the .war file named as **conwaygol.war** in the target folder, and war can be deployed on tomcat. To access the application, please use the following url: 
```
localhost:8080/conwaygol/start
```

* Another way to run the application would be to execute the **ConwayGolApplication.java** class as Java Application. To access the application, please use the following url: 
```
localhost:8080/conwaygol/start
```

**This application provides basic implementation Conway's Game of life, and it is developed using following technologies:**
```
Java
Spring Boot
Spring MVC Rest
AngularJS
Junit/Mockeito 
```

