#!/bin/bash
docker rm cm-reports
docker run --name cm-reports -d -p 9898:8080/tcp -v $PWD/logs:/var/log/tomcat8 mcare-wifi/cm-reports
