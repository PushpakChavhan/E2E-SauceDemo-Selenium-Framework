pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        GRID = 'grid'
        BROWSER = 'chrome'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/<your-username>/E2E-Ecommerce-Selenium-Hybrid-Framework.git'
            }
        }

        stage('Start Selenium Grid') {
            steps {
                dir('docker') {
                    bat 'docker-compose down'
                    bat 'docker-compose up -d'
                }
            }
        }

        stage('Run Automation Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        always {
            publishHTML(target: [
                reportDir: 'test-output',
                reportFiles: 'ExtentReport.html',
                reportName: 'Automation Test Report',
                keepAll: true,
                allowMissing: false,
                alwaysLinkToLastBuild: true
            ])
        }

        cleanup {
            dir('docker') {
                bat 'docker-compose down'
            }
        }
    }
}
