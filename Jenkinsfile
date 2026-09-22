pipeline {

    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3.9'
    }

    stages {

        stage('Git checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/suryaprakash-bandoju/2-Tier-Java-Project-Task-Management-Service.git'
            }
        }

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
