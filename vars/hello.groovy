#!/usr/bin/env groovy


def call(String name) {

    sh "echo hello $name"

    def script = libraryResource 'hello-world.sh'

    println script

}