#!/usr/bin/env groovy

import com.dminc.GitCommit

def call(Map args) {
  stage('Checkout source code') {
    checkout scm
    String commitId = sh(script: 'git rev-parse HEAD', returnStdout: true)
    GitCommit gitCommit = new GitCommit(id: commitId)
    return gitCommit
  }
}