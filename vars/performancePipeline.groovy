#!/usr/bin/env groovy
def call(body) {
    pipeline {

        agent any

        parameters {
            choice (name: "env",
                    description: "",
                    choices: "${config.parameterChoiceEnv}")
            choice (name: "load",
                    description: "",
                    choices: "${config.parameterChoiceLoad}")
            choice (name: "duration",
                    description: "",
                    choices: "${config.parameterChoiceDuration}")
            string (name: "branch",
                    description: "Choose which branch to check out the test",
                    defaultValue: "${config.parameterStringBranch}")
        }

        stages {

            stage("clean") {
                steps {
                    cleanWs()
                }
            }

            stage("checkout") {
                steps {
                    echo "Checking out the ${config.projectName} project from the ${params.branch} branch in ${config.projectUrl}\n"
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
