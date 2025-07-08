pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Static Analysis (Checkstyle)') {
            steps {
                sh 'mvn checkstyle:checkstyle'
            }
            post {
                always {
                    recordIssues(tools: [checkStyle(pattern: '**/target/checkstyle-result.xml')])
                }
            }
        }
        stage('Test and Coverage (JaCoCo)') {
            steps {
                sh 'mvn test jacoco:report'
            }
            post {
                always {
                    jacoco(execPattern: '**/target/*.exec', classPattern: '**/target/classes', sourcePattern: '**/src/main/java')
                }
            }
        }
        stage('Generate Site') {
            steps {
                sh 'mvn site'
            }
        }
    }

    post {
        success {
            echo 'Pipeline finalizado con éxito'
        }
        failure {
            echo 'Pipeline ha fallado'
        }
    }
}
