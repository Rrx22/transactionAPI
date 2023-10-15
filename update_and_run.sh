#!/bin/bash

# Shut down Docker containers using Docker Compose
docker-compose down

# Clean and package with Maven
mvn clean package

# Build Docker image
docker build -t transactionapi:latest .

# Bring up Docker containers using Docker Compose
docker-compose up
