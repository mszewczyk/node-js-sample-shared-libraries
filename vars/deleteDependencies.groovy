#!/usr/bin/env groovy

def call(Map args) {
  stage('Deleting dependencies') {
      echo 'Deleting dependencies...'
      cleanWs patterns: [[
              pattern: 'node_modules',
              type: 'INCLUDE'
          ]],
          deleteDirs: true
  }
}