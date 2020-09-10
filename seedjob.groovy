def jobs = [[name:'Test repo',branch:'*/master',repo:'hoexter/cicdcop']]

jobs.each { i ->
    pipelineJob(i.name) {
        logRotator() {
            numToKeep(10)
        }
        definition {
            cpsScm {
                scm {
                    git("git@github.com:${i.repo}.git",
                            i.branch)
                }
                scriptPath('Jenkinsfile')
            }
        }
    }
}
