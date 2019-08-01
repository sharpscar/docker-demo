job('NodeJS Docker example'){
    scm {
        git('https://github.com/sharpscar/docker-demo.git'){
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
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}