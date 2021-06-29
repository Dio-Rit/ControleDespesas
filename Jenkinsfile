pipeline{
    environment {
        BRANCH_NAME = "${env.BRANCH_NAME}"
    }
    agent any
    stages {
        stage ('Build App - Homologação'){
            steps{
				sh 'cp Dev/db.properties src/main/resources/db.properties'
				sh 'cp Dev/db.changelog-master.yaml src/main/resources/db/changelog/db.changelog-master.yaml'
				sh 'mvn clean install -DskipTests=true'
            }
        }
        stage ('Liquibase Homologação'){
            steps{
                sh 'mvn liquibase:update'
            }
        }
        stage ('Deploy App - Homologação') {
            steps {
                sh 'docker-compose up --build --force-recreate -d'
            }
        }
        stage ( 'Approval Production Deploy' ) {
            steps {
                script {
                    timeout(time: 12, unit: 'HOURS') {
                        input message: 'Aprovar a implantação em produção?', ok: 'Sim'
                    }
                }
            }
        }
        stage ('Build App - Production') {
            steps {
				sh 'cp Prod/db.properties src/main/resources/db.properties'
				sh 'cp Prod/db.changelog-master.yaml src/main/resources/db/changelog/db.changelog-master.yaml'
				sh 'mvn clean install -DskipTests=true'
            }
        }
		stage ('Deploy App - Production') {
            steps {
				sh 'docker-compose -f docker-compose-prod.yml up --build --force-recreate -d'
            }
        }
		stage ('Liquibase Production'){
            steps{
                sh 'mvn liquibase:update'
            }
        }
    }
}
