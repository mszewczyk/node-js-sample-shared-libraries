#!/usr/bin/env groovy

def call(Map args) {
  stage('Install dependencies') {
      echo 'Installing dependencies...'
      sh 'npm install'
  }
}