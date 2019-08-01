job('NodeJS example'){
    scm{
        git('https://github.com/sharpscar/docker-demo.git'){
            node / gitConfigName('sharpscar')
            node / gitConfigEmail('sharpscar@gmail.com')
        }
    }
    triggers{
        scm('H/S * * * * ')

    }
    wrappers{
        nodejs('nodejs')
    }
    steps{
        shell("npm install")
    }
}