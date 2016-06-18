FROM docker-mobicare.netcombowifi.com.br/tomcat8-log4j-logstash

MAINTAINER equipe-operacao@mobicare.com.br

ENV RDS_MAX_ACTIVE 4
ENV RDS_MAX_IDLE 1
ENV RDS_USERNAME publicserveruser
ENV RDS_PASSWORD V5EGCBKBAS
ENV RDS_JDBC_URL jdbc:mysql://net-wifi-public-services-db.cm2al8mslmkz.sa-east-1.rds.amazonaws.com:3306/net_wifi_public_services_db

ADD ./src/main/tomcat/conf/context.xml $TOMCAT_HOME/conf/context.xml
ADD ./target/cm-reports.war $TOMCAT_HOME/webapps/cm-reports.war