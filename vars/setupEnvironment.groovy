#!/usr/bin/env groovy

import com.dminc.GitCommit

def call(Map args) {
  env.NODEJS_HOME = "${tool 'NodeJS'}"
  env.PATH="${env.NODEJS_HOME}/bin:${env.PATH}"
  
  String commitId = sh(script: 'git rev-parse HEAD', returnStdout: true)
  GitCommit gitCommit = new GitCommit(id: commitId)
  return gitCommit
}