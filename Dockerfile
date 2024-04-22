FROM jenkins/jenkins:lts
USER root
RUN apt-get update && apt-get install -y maven
RUN apt-get install -y libxcb1
USER jenkins
