# Plex
[![Jenkins](https://jenkins.upnetix.cloud/buildStatus/icon?job=DevOps%2FTests%2Ftest-mbp%2Fdevelop)](https://jenkins.upnetix.cloud/job/DevOps/job/Tests/job/test-mbp/job/develop/)
[![Sonar](https://sonar.upnetix.cloud/api/project_badges/measure?project=com.upnetix.java%3Aplex-user-name%3Adev&metric=alert_status)](https://sonar.upnetix.cloud/dashboard?id=com.upnetix.java%3Aplex-user-name%3Adev)

Project is designed to categorize and sort movies,series(with the corresponding seasons,episodes etc.) using Plex generated SQLite Database and a third-party API (like OMDb API)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You need to have installed:

```
Maven
Java 8
```

### Installing

A step by step series of examples that tell you how to get a the project running

```
1) mvn clean package (generates the .jar)
```

After that you can run the project using:

```
2) java -jar target/<PROJECT-NAME>.jar
```
## Running from the IDE
```
1) Import Maven project and start the Java project from the main method
```

After that in separate terminal run:

```
2) webpack --watch --watch-poll --progress --hide-modules
```

Go to your browser and visit:

```
3) localhost:8080
```
## Running the tests

You can run all the tests using:

```
mvn test
```
### Coding style 

For this project is used the official Upnetix Checkstyle

## Deployment

If you want to deploy the project on a live server,you have to secure copy through SSH the .jar,and then run it

```
scp target/<PROJECT-NAME>.jar yourusername@yourserver:/home/yourusername/
[yourusername@yourserver ~]$ java -jar <PROJECT-NAME>.jar
```
## Built With

* [Spring](https://spring.io/docs) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [InteliJ](https://www.jetbrains.com/idea/documentation/) - IDE


## Versioning

For the versions available, see the tags on this repository 

## Authors

* **Jordan Popov** - [yordan.popov@upnetix.com](mailto:yordan.popov@upnetix.com) - Initial FrontEnd Skeleton
* **Elena Vuchkova & Zhestislava Evgenieva** - [elena.vuchkova@upnetix.com](mailto:elenavuchkova@upnetix.com) & [zhestislava.evgenieva@upnetix.com](mailto:zhestislava.evgenieva@upnetix.com) - Initial BackEnd Skeleton

## Acknowledgments

* Mentor: [insert your mentor name here]


