#!/usr/bin/env groovy

def call(Map args) {
  env.NODEJS_HOME = "${tool 'NodeJS'}"
  env.PATH="${env.NODEJS_HOME}/bin:${env.PATH}"
}