#!/usr/bin/env groovy

def call(Map args) {
  stage('Package application') {
      echo 'Packaging application...'
      sh 'npm pack'
  }
}