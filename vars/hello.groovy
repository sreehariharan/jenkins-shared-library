#!/usr/bin/env groovy


def call(String name) {

    sh "echo hello $name"

    def script = libraryResource 'hello-world.sh'

    writeFile encoding: 'UTF-8', file: 'hello-script.sh', text: script

    sh "chmod 755 hello-script.sh && ./hello-script.sh"

}