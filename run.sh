#!/bin/bash

service mysql restart

cd /airts/dev/APIGateway
mvn -Dmaven.test.skip=true tomcat7:run &
cd /airts/dev/FlightSearch
mvn -Dmaven.test.skip=true tomcat7:run &
cd /airts/dev/Booking
mvn -Dmaven.test.skip=true tomcat7:run 


