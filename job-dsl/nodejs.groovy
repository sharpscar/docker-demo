job('NodeJS example'){
    scm{
        git('https://github.com/sharpscar/simple_node_helloworld'){
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
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