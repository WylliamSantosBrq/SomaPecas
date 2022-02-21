pipeline {
    agent any
    tools{
        jdk "JAVA_HOME"
    }
    stages {
   		stage ('Tests execution'){
   			steps {
   				sh 'mvn -Dmaven.test.failure.ignore=true install'    
   			}     		
   		}

   	}
}


