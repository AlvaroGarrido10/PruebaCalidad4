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
                bat 'mvn clean compile'
            }
        }
        stage('Static Analysis (Checkstyle)') {
            steps {
                bat 'mvn checkstyle:checkstyle'
            }
            post {
                always {
                    recordIssues(tools: [checkStyle(pattern: '**/target/checkstyle-result.xml')])
                }
            }
        }
        stage('Test and Coverage (JaCoCo)') {
            steps {
                bat 'mvn test jacoco:report'
            }
            post {
                success {
                    echo 'Tests pasaron correctamente'
                }
                failure {
                    error 'Tests fallaron, abortando pipeline'
                }
                always {
                    jacoco(execPattern: '**/target/*.exec', classPattern: '**/target/classes', sourcePattern: '**/src/main/java')
                }
            }
        }
        stage('Generate Site') {
            steps {
                bat 'mvn site'
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
