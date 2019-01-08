#!/usr/bin/env groovy

def call(Map args) {
  def appName = args.appName

  stage('Deploy to Heroku') {
    if (env.TAG_NAME) {
      echo 'Deploying to Heroku...'
      withCredentials([usernamePassword(credentialsId: 'heroku', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
          sh "git push https://${USERNAME}:${PASSWORD}@git.heroku.com/${appName}.git ${env.TAG_NAME}:master"
      }
    } else {
      echo 'Not a release. Skipping deployment.'
    }
  }
}