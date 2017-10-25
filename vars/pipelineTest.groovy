#!/usr/bin/env groovy

def call(String projectUrl = 'undefined', String projectName = 'undefined', String thisTest = 'undefined', String parameterChoiceEnv = 'undefined', String parameterChoiceLoad = 'undefined', String parameterChoiceDuration = 'undefined', String parameterStringBranch = 'undefined') {
    pipeline {

        agent any

        parameters {
            choice (name: "env",
                    description: "",
                    choices: "${parameterChoiceEnv}")
            choice (name: "load",
                    description: "",
                    choices: "${parameterChoiceLoad}")
            choice (name: "duration",
                    description: "",
                    choices: "${parameterChoiceDuration}")
            string (name: "branch",
                    description: "Choose which branch to check out the test",
                    defaultValue: "${parameterStringBranch}")
        }

        stages {

            stage("clean") {
                steps {
                    cleanWs()
                }
            }

            stage("checkout") {
                steps {
                    echo "Checking out the ${projectName} project from the ${branch} branch in ${projectUrl}\n"
                }
            }

            stage("loadtest") {
                steps {
                    echo "Running the test in ${params.env} with ${params.load} load for ${params.duration}\n"
                    ansiColor("xterm") {
                        sh "echo 'Running the test!'"
                    }
                }
            }
        }
    }
}
