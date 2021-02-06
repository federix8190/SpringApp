#!/bin/bash

echo "Downloading dependencies..."

mvn clean package spring-boot:repackage

echo "###########################################################################################################"
echo "############################################## DONE DOWNLOAD ##############################################"
echo "###########################################################################################################"

echo "Starting core-federix by jar..."
VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
java -jar target/core-federix-${VERSION}.jar
