#!/bin/bash

cd dev/APIGateway
mvn -Dmaven.test.skip=true tomcat7:run &
cd ../FlightSearch
mvn -Dmaven.test.skip=true tomcat7:run &
cd ../Booking
mvn -Dmaven.test.skip=true tomcat7:run &


