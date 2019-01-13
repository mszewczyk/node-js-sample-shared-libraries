#!/usr/bin/env groovy

import com.dminc.Heroku

def call(Map args) {
  def appName = args.appName

  stage('Deploy to Heroku') {
    Heroku heroku = new Heroku(this, appName)
    heroku.deploy()
  }
}