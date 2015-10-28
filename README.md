RESTful Webservice with Swagger and Docker

This is a sample application demonstrating simple RESTful Webservices with swagger and docker.

docker spawns the tomcat in a separate container.
To run the docker, first open the docker client and then fire the mvn docker build command.
mvn package docker:build

You can access the web-services at:
http://192.168.99.100:8080/restfuldocker/
