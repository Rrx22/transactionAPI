# Table of Contents

1. [Introduction](#introduction)
2. [System Requirements](#system-requirements)
3. [Setup](#setup)
4. [Build and run](#build-and-run)
5. [Try it out](#try-it-out-)

### Introduction:
todo

### System Requirements:
Maven, Docker, Docker-Compose

### Setup:
**.env file:**

Create a .env file in project root folder for credentials. Note that the credentials for MYSQL and SPRING_DATASOURCE should be identical.
````
MYSQL_USER=user
MYSQL_PASSWORD=password
MYSQL_ROOT_PASSWORD=password

SPRING_DATASOURCE_USERNAME=user
SPRING_DATASOURCE_PASSWORD=password
````

### Build and run:
Run update_and_run.sh

### Try it out: 
Test Api on http://localhost:8080/swagger-ui/index.html

