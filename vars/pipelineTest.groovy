def call(String env = 'undefined', String load = 'undefined', String duration = 'undefined') {
    pipeline {

        agent any

        String PROJECT_REPO = "git@github.com:smithbr/dotfiles.git"
        String PROJECT_REPO_NAME = "smithbr/dotfiles"
        String THIS_PROJECT = "dotfiles"
        String THIS_TEST = "DotFilesTest"

        parameters {
            choice (name: "env",
                    description: "",
                    choices: "qa\nprod\nstage\n")
            choice (name: "load",
                    description: "",
                    choices: "singleuser\nlight\nnormal\npeak\n2peak\n3peak\n")
            choice (name: "duration",
                    description: "",
                    choices: "30s\n1m\n5m\n10m\n30m\n1h\n2h\n")
            string (name: "branch",
                    description: "Choose which branch to check out the test",
                    defaultValue: "master")
        }

        stages {

            stage("clean") {
                steps {
                    cleanWs()
                }
            }

            stage("checkout") {
                steps {
                    echo "Checking out the ${THIS_PROJECT} project from the ${branch} branch in ${PROJECT_REPO_NAME}\n"
                }
            }

            stage("loadtest") {
                steps {
                    echo "Running the test in ${params.env} with ${params.load} load for ${params.duration}\n"
                    ansiColor("xterm") {
                        sh "echo 'Running the test!''"
                    }
                }
            }
        }
    }
}
