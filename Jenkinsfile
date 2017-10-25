@Library('sqe-ci') _

// test details
def projectUrl = 'git@github.com:smithbr/dotfiles.git'
def projectName = 'dotfiles'
def thisTest = 'DotFilesTest'

// parameters
def parameterChoiceEnv = "qa\nprod\nstage\n"
def parameterChoiceLoad = "singleuser\nlight\nnormal\npeak\n2peak\n3peak\n"
def parameterChoiceDuration = "30s\n1m\n5m\n10m\n30m\n1h\n2h\n"
def parameterStringBranch = "master"

pipelineTest(projectUrl, projectName, thisTest, parameterChoiceEnv, parameterChoiceLoad, parameterChoiceDuration, parameterStringBranch)
