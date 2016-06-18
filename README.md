CrossOver
Implementation Guidelines for Airline Ticket Reservation System
Author : Mário de Sá Vera
Date : June 18th 2016


	This document presents a detailed description of the implementation process of the proposed Airline Ticket Reservation System (named Air-TS) as well as installation instructions for system testing. The implementation follows the design document located at :

var/doc/DESAVERA-DESIGN-DOCUMENT-2016-05.pdf

	The installation instructions are divided in two different scenarios for a Junior Developer as a target for taking along this implementation (i.e. a development environment) and a testing environment using cloud computing for all system architecture modules.

1- Technologies integrated

	As a JAVA stack solution and attending to the work scope we will use the following technologies for the system implementation :

- Linux 

Both the development and testing environment will run on Linux Ubuntu flavour as the operating system. This is due to the facilities offered for both developer and operational profiles (i.e. devops). Linux also offers a very stable and open source compatible environment as most of the technologies used in both development and testing environment with Amazon Web Services.

- Amazon Web Services (AWS)

Amazon services for cloud computing were used for testing environment infrastructure as it offers from a no costs infrastructure up to full production services for high scaling systems for eventual future options. The following services were used from AWS :

* EC2 was chosen with the minimum resources configured in order to enable the system testing environment (i.e. Ubuntu Server 14.04 LTS (HVM), SSD Volume Type).

other services like RDS and SNS for database and messaging should be also integrated in the future.As of the time of this writing these services will be installed as part of the system images configured for deployment with Docker.io.

- Docker.io

Docker.io is a container image manager where we are able to configure a whole infrastructure with all services integrated so that a deployment of a testing or production environment can be done with no configuration difference between environments.

- MySQL

MySQL is an open source natural choice for simplicity and it addresses perfectly the scenario exposed in the trial.

- Apache Tomcat and ActiveMQ

Tomcat is a very simple, robust and easy to install Application Server in Linux systems and it addresses perfectly the scenario exposed in the trial as well as offers solid integration with both MySQL and Spring frameworks.

- Spring Frameworks

Spring is a major integrator itself of several technologies. The Spring Boot project was quite helpful by providing both a JPA container for ORM as well as deployment starters with embedded containers (ex : Apache Tomcat and ActiveMQ) directly from Maven dependency declarations.

- Apache Maven

The build engine of our choice was Maven. Even though quite a verbosous tool it made dependency management for the set of technologies used quite simple.



2- Design patterns and principles used


As a rule of thumb for any system architecture the low coupling and high cohesion of system modules are the main goals. Most patterns and principles adopted aim these two concepts.

- Software as a Service/Microservices architecture

In order to achieve a high level of decoupling between system components we will go for a fine-grained modular architecture where each system module will be responsible for a specific functional use case (and high cohesion too). As we want to take advantage of Web Applications features like easy access and maintenance the system will be developed as a set of web services in a cloud distributed infrastructure.

- MVC

Basically we do not want to mix presentation layout user interface logic with business logic so that requirements like REQ_OPER_SERVER_FLEX_ARCH for enabling mobile apps without any modification suggests and justify the MVC pattern as the View layer shall be adapted for specific clients.

- RESTful API with an API Gateway

A RESTful services architecture with a API gateway is a Mediator design pattern with a central (i.e. the Gateway) component receiving external first hit from client applications as well as mediating the comunication between services as a router.



3- Installation instructions

For running Air-TS system I recommend :

- 700 MHz processor (about Intel Celeron or better)
- 512 MiB RAM (system memory)
- 5 GB of hard-drive space (or USB stick, memory card or external drive but see LiveCD for an alternative approach)
- Linux system (Ubuntu 14.04 up recommended) admin user account access
- internet access with Download Speed around 2Mbps / 512kbps
- maven installed
- jdk 1.8 installed

For installation from the pack source code :

# apt-get install maven
# unzip DESAVERA_CA_Air2.zip  
# cd [unziped directory]
# mvn install tomcat7:run

check the installation complete message and the system is ready to be tested by accessing in a web browser as http://localhost:8080

For installation from a system image :

Docker.io is the container technology and in order to download the Air-TS development image you should (from an admin unix shell) :

# apt-get install docker
# unzip DESAVERA_CA_Air2.zip  
# cd [unziped directory]
# ./run.sh

check the installation complete message and the system is ready to be tested by accessing in a web browser as http://localhost:8080

4- Database creation and initialization

For a Linux system with MySQL 5.5 or newer installed there should be :

DBUSERNAME : airtsdev
DBPASSWORD : airts123

after login into MySQL :

mysql> source DB-RESERVATION-CORE.sql

and in order to populate the initial mock data into the AIRTS development database instance :

mysql> source DB-RESERVATION-DATA.sql

you now have the database ready for running the AIRTS system.

5- Assumptions adopted


I am assuming two deployment scenarios for the system in the current implementation. The one I am delivering here is a development scenario and not a production scenario where the services would be deployed in cloud based infrastructures. This is due to an absolute lack of time for configuring the production environment. Nevertheless the source code for all services will need no modification for a production deployment. The usage of Docker.io was actually going on that direction.

Another assumption is that the development environment target is a junior developer so that the major complexities envolved in the system implementation were at least referenced with adequate solutions so that a sort of copy and paste development could take place for things like continuing the development of the other services and so on. With that in mind the choice for Spring Boot and AngularJS were critical due to the suage of frameworks from a point of discipline view enforces good practices which would not be guaranteed to be taken in case of a more loose approach in terms of integrated technologies.

Finally, in terms of infrastructure I assume the system tester with admin access to a Linux Ubuntu system with MySQL installed.

6- Requirements not covered by the current implementation 

Actually most requirements were not covered unfortunately due to the short time available for implementation.Real life considerations with system security ,scalability and so on were not covered also.
 
7- General issues

This is a mock system.There are several complexities of a real time Airline Tickets Reservation System would have to take care of (ex : multiple stops flights) that were ignored by the architecture and implementation also. There was absolutely no time for coding most of the services and as a future work for a junior developer hands-on collaboration I would suggest the following agenda :

- Spring Boot education with JPA
- AngularJS education with oauth integration
- Development of the complete set of Services
- Development of the JMS utilities components as the poller , mailer (i.e. those specified in the architecture)
- Download of Air-TS container for development infrastructure deployment 

my estimate is that a system of this size would require 2 months development for an alpha release with myself as the tech lead and a junior developer helping me out.


8- Feedback

A very challenging trial folks ! The only issu I had was that the second trial home page is not in sync with the application page and that took me about a week to be able to start the second trial. Unfortunately I had no time for implementation as the services architecture , ORM and infrastructure configuration were all done from scratch and I am currently employed and had to work late nights and so on. I am currently with the integration of ActiveMQ and Spring Boot documentation open in my Browser as well as services like SendGrid in order to deliver the emails confirmation after Booking complete.AngularJS is quite appropriate for client side development of payment services integration with PayPal and Google Wallet. In order words, I feel very safe to say I have delivered right direction technologies in this implementation for the complexities of the trial and if this is what a day-to-day work would look like I feel comfortable to say I am a good candidate for the position at least that is what it sounds to me.

My expectation is of a chance for a phone or skype screening with one of your engineers so we can debate over my delivery hereby. Working remotely will be a new experience and I am willing to take a chance.



Thanks for the opportunity,

Mario.

