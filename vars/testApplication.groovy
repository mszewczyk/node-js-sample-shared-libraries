#!/usr/bin/env groovy

def call(Map args) {
  stage('Test application') {
    echo 'Testing application...'
    sh 'npm test'
  }
}
