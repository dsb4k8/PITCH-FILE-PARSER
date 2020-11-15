# CBOE PITCH ParserCBOE PITCH Parser

A Simple Full-Stack Spring Boot Web Application for PITCH file analysis.

## Running LocallyRunning Locally

To demo this web application:
Double-click the executable jar file I have included with this project submission.
Navigate to [http://localhost:8080/.](http://localhost:8080/.) This project works best with Chrome.
If you wish to query the generated database tables, you may navigate to [http://localhost:8080/h2-console](http://localhost:8080/h2-console) >>Note, the table file_submissions will be
empty until you have you have successfully uploaded a PITCH txt file
When you are finished reviewing this project, be sure to open your operating system's task manager and end/terminate/kill the process OpenJDK Platform
binary.

## Project StructureProject Structure

This Project follows MVC Design pattern.

## Back-EndBack-End

Directories pertaining to business logic and ORM can be found here: CBOE\CBOEPitchWebApp\src\main\java\net\diegobrown
This directory contains packages/ subdirectories: controller, domain, and service

## Front-EndFront-End

The assets included in this project submission are original works created by me in Affinity Designer.
Directories pertaining to Front-End rendering, styling and client-side logic can be found here: CBOE\CBOEPitchWebApp\src\main\resources
Frontend - This directory contains subdirectories: static\assets, static\clientside_scripts, static\styles

HTML templates can be found here: \resources\templates

## H2 Database configurationH2 Database configuration

```
\CBOEPitchWebApp\src\main\resources\application.properties
```
## Maven DependenciesMaven Dependencies

```
\CBOE\CBOEPitchWebApp\pom.xml
```

Diego S. Brown
