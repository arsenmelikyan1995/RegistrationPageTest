#!/bin/bash
origin_jar_name="RegistrationPage-0.0.1.war"
rename_jar_name="RegistrationPage.war"

echo "########## BUILDING JAR FILE ##########"
mvn clean package install

echo "########## RENAME JAR FILE ##########"
mv target/$origin_jar_name  /var/lib/tomcat8/webapps/$rename_jar_name

