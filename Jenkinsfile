pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "3.8.5"
      jdk "11.0.17"
   }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'main', name: 'BRANCH', type: 'PT_BRANCH'
        booleanParam(defaultValue: true, description: 'Headless mode', name: 'HEADLESS')
        string(name: 'DEPLOY_ENV', defaultValue: 'staging', description: '')
    }

   stages {
      stage('Testing') {
         steps {
            // Get some code from a GitHub repository
            git branch: "${params.BRANCH}", url: 'https://github.com/LiliYunusova/qase_project.git'

            // Run Maven on a Unix agent.
            //sh "mvn clean test"

            // To run Maven on a Windows agent, use
            bat "mvn -Dmaven.test.failure.ignore=true -Dbrowser=chrome -Demail=liliya.yunusova.spare@gmail.com -Dpassword=32kq4WxW  -Dsurefire.suiteXmlFiles=src/test/resources/smoke.xml clean test"
         }

         post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
               junit '**/target/surefire-reports/TEST-*.xml'
            }
         }
      }
      stage('Reporting') {
         steps {
             script {
                     allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'target/allure-results']]
                     ])
             }
         }
        }
   }
}