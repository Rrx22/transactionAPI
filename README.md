#### System Requirements:
Maven, Docker, Docker-Compose

#### Setup:
Create a .env file in project root folder for credentials. Note that the MYSQL and SPRING_DATASOURCE credentials should be the same.
````
MYSQL_USER=user
MYSQL_PASSWORD=password
MYSQL_ROOT_PASSWORD=password

SPRING_DATASOURCE_USERNAME=user
SPRING_DATASOURCE_PASSWORD=password
````

#### Build and run:
Run update_and_run.sh

#### Try it out: 
Test Api on http://localhost:8080/swagger-ui/index.html

