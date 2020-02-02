# E Journal
[![Jenkins](https://jenkins.upnetix.cloud/buildStatus/icon?job=DevOps%2FTests%2Ftest-mbp%2Fdevelop)](https://jenkins.upnetix.cloud/job/DevOps/job/Tests/job/test-mbp/job/develop/)
[![Sonar](https://sonar.upnetix.cloud/api/project_badges/measure?project=com.upnetix.java%3Aplex-user-name%3Adev&metric=alert_status)](https://sonar.upnetix.cloud/dashboard?id=com.upnetix.java%3Aplex-user-name%3Adev)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

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

## Author

* **Kristiyan Parvanov** - [kristian.parvanov95@gmail.com](mailto:kristian.parvanov95@gmail.com)


