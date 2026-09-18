pipeline {
    agent any
    
    tools {
        jdk 'jdk17'
        maven 'maven3.9'
    }

    stages {
        stage('Compiling') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('Testing') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Packaging') {
            steps {
                sh 'mvn package'
            }
        }
    }
}
