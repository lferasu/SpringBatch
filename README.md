# SpringBatch

This project contains a full stack application for executing a spring bactch process.
- client application : 
	- secure login 
	- a page to start the batch process
- server
	- rest api to start batch process
- docker compose file
	- a docker compose file that downloads the application and its dependency(mysql) from docker hub and start the appllication 
- a students.csv file that needs to be processed.
	
How to start the application


How to run the application

full code is available at : https://github.com/lferasu/SpringBatch.git

Method 1 (downloading the app from docker hub)
	
	a)get the docker-compose.yml file
	b)execute docker-compose up on your docker platform
      this downloads the application and its dependency from docker hub and starts the application
	c)go to http://localhost:8080
	d)log-in with username: user , password: password
	e)click on the button start bactch job button 
		this will start the server side application and database will be populated from the student.csv file
	

Method 2 (building locally)

	a) build the application by using "mvn clean package"
	b)rename docker-compose-local.yml to docker-compose.yml (you  have to rename the existin docker-compose.yml file to somethingelse)
	c)execute docker-compose up on your docker platform
      this builds the spring application , make a local docker image and starts the application
	d)go to http://localhost:8080
	e)log-in with username: user , password: password
	f)click on the button start bactch job button
		this will start the server side application and database will be populated from the student.csv file
	
	