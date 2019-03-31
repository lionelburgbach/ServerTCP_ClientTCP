FROM java:8
MAINTAINER Nicodeme Stalder <nicodeme.stalder@heig-vd.ch>

COPY TCP-Client-1.0-SNAPSHOT-standalone.jar /opt/app/client.jar

EXPOSE 2019

ENTRYPOINT ["java","-jar","/opt/app/client.jar"]
CMD ["172.17.0.2","2424"]
