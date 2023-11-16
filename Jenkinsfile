pipeline {
    agent any

    tools {
        jdk '19'
    }

    stages {
        stage('Build') {
            steps {
                // Run Gradle build
                // Assumes that Gradle wrapper (gradlew) is part of your repository
                sh './gradlew build'
            }
        }

        stage('Test') {
            steps {
                // Run tests
                // This can be customized based on your project's requirements
                sh './gradlew test'
            }
            post {
                always {
                    junit 'build/test-results/test/**/*.xml'
                }
            }
        }
    }
}
