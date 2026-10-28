pipeline {
   agent any
   tools {
       jdk 'Java21'
   }
   options {
       disableConcurrentBuilds()
       buildDiscarder(logRotator(numToKeepStr: '10'))
       timeout(time: 20, unit: 'MINUTES')
   }
   triggers {
       pollSCM('H/5 * * * *')
   }
   stages {
       stage('Verificar herramientas') {
           steps {
               bat 'java -version'
               bat 'gradlew.bat --version'
           }
       }
       stage('Ejecutar pruebas web') {
           steps {
               bat 'gradlew.bat clean test aggregate --no-daemon -Dheadless.mode=true'
           }
           post {
               always {
                   archiveArtifacts(
                       artifacts: 'target/site/serenity/**',
                       allowEmptyArchive: true
                   )
                   junit(
                       testResults: 'build/test-results/test/TEST-*.xml',
                       allowEmptyResults: false
                   )
               }
           }
       }
   }
}