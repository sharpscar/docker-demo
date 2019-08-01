job('NodeJS Docker example'){
    scm {
        git('https://github.com/sharpscar/simple_node_helloworld'){
            node / gitConfigName('sharpscar')
            node / gitConfigEmail('sharpscar@gmail.com')
        }
    }

    triggers{
        scm('H/5 * * * *')
    }
    wrappers{
        nodejs('nodejs')
    }
    steps{
        dockerBuildAndPublish{
            repositoryName('sharpscar/docker-nodejs-demo')
            tag('${GIT_REVISION, length-9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}