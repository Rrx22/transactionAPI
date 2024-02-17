#!/bin/bash

echo '******
STEP 1: Shut down Docker containers using Docker Compose
******'
docker-compose down

echo '******
STEP 2: Clean and package with Maven
******'
mvn clean package

echo '******
STEP 3: Build Docker image
******'
docker build -t transactionapi:latest .

echo '******
STEP 4: Bring up Docker containers using Docker Compose
******'
docker-compose up
