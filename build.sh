#!/bin/bash
origin_war_name="RegistrationPage-0.0.1.war"
rename_war_name="RegistrationPage.war"

echo "########## BUILDING WAR FILE ##########"
mvn clean package install

echo "########## STOP TOMCAT ##########"
sudo service tomcat8 stop

echo "########## MOVE WAR FILE ##########"
sudo rm -rf /var/lib/tomcat8/webapps/$rename_war_name*
sudo mv target/$origin_war_name  /var/lib/tomcat8/webapps/$rename_war_name

echo "########## START TOMCAT ##########"
sudo service tomcat8 start