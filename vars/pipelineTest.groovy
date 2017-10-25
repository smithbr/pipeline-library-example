def call() {

    pipeline {

        agent any

        parameters {
            choice (name: "ddd",
                    description: "",
                    choices: "111\n222\n333\n")
            choice (name: "ccc",
                    description: "",
                    choices: "444\n555\n666\n777\n888\n999\n")
            choice (name: "bbb",
                    description: "",
                    choices: "111\n222\n333\n444\n555\n666\n777\n")
            string (name: "aaa",
                    description: "Choose which branch to check out the test",
                    defaultValue: "master")
        }

        stages {

            stage("setup") {
                steps {
                    cleanWs()
                    echo "Checking out\n"
                }
            }

            stage("loadtest") {
                steps {
                    echo "234234234234\n"
                    echo "askdfkajsdf\n"
                    ansiColor("xterm") {
                        sh "ls -la"
                        sh "pwd"
                    }
                }
            }

        }

        post {
            always {
                cleanWs()
            }
        }
    }
}
