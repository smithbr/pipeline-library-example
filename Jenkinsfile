#!/usr/bin/env groovy
@Library('sqe-ci') _

performancePipeline {
    projectUrl = 'git@github.com:smithbr/dotfiles.git'
    projectName = 'dotfiles'
    thisTest = 'DotFilesTest'
    parameterChoiceEnv = "qa\nprod\nstage\n"
    parameterChoiceLoad = "singleuser\nlight\nnormal\npeak\n2peak\n3peak\n"
    parameterChoiceDuration = "30s\n1m\n5m\n10m\n30m\n1h\n2h\n"
    parameterStringBranch = "master"
}
