#!/usr/bin/env groovy

def call(Map args) {
  stage('Checkout source code') {
      checkout scm
  }
}