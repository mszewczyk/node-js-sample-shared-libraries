package com.dminc

class Heroku {
  def pipeline
  def appName

  void deploy() {
    if (thisIsARelease()) {
      logToConsole('Deploying to Heroku...')
      pushToHerokuGitRepo()
    } else {
      logToConsole('Not a release. Skipping deployment.')
    }
  }

  private boolean thisIsARelease() {
    pipeline.env.TAG_NAME
  }

  private void logToConsole(message) {
    pipeline.echo message
  }

  private void pushToHerokuGitRepo() {
    withCredentials([usernamePassword(credentialsId: 'heroku', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
      sh "git push https://${USERNAME}:${PASSWORD}@git.heroku.com/${appName}.git ${pipeline.env.TAG_NAME}:master"
    }
  }
}