pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        DOCKERHUB_PWD = credentials('dockerhub-pwd')
    }

    stages {

        stage('Check out') {
            steps {
                git branch: 'main', url: 'https://github.com/Kianaa-Kooshesh-02/comp367-DevOps-lab2-ci-webapp'
            }
        }

        stage('Build maven project') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker build') {
            steps {
                script {
                    sh 'docker build -t kianakoinfra/lab3-webapp:1.0 .'
                }
            }
        }

        stage('Docker login') {
            steps {
                script {
                    sh 'docker login -u kianakoinfra -p ${DOCKERHUB_PWD}'
                }
            }
        }

        stage('Docker push') {
            steps {
                script {
                    sh 'docker push kianakoinfra/lab3-webapp:1.0'
                }
            }
        }
    }
}
