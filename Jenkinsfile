pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat "mvnw.cmd clean deploy"
            }
        }
    }
}
