pipeline {
    agent {
        docker{
        	   image 'openjdk:8-jre'
         	   image 'mjalas/javafx:latest'
               image 'maven:3-alpine'
               args '-v /root/.m2:/root/.m2'
        }
    }
           stages {
               stage('Build') {
                   steps {
                       sh 'mvn clean package'
                   }
               }
           }
}
