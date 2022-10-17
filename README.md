# README #

This Repo contains the jenkins file to run the pipelin which contains 5 stages : 
* Cloning the git repo of the source code
* Build docker image
* Upload the docker image 
* Run the image 
* Run auto tests

## Prerequisites ##

* locally installed : 
-- Docker
-- Jenkins
-- NodeJs
-- npm

### Test plan ###

* The end to end tests are created in a postman collection https://www.getpostman.com/collections/0635deaae6e962860ec1
* the are integrated with jenkins using newman 

### How to run ###
 
 * Run the Jenkins pipeline shared in this repo in the file "jenkinsfile", it allows to clone the git code, build and run the project's image in a docker container.
 * The tests checks endpoints by listening to the port 8080
