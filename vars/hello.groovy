#!/usr/bin/env groovy
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder


def call(String name) {

    sh "echo hello $name"

    def script = libraryResource 'hello-world.sh'

    writeFile encoding: 'UTF-8', file: 'hello-script.sh', text: script

    sh "chmod 755 hello-script.sh && ./hello-script.sh"


    def yaml = libraryResource 'test.yml'
    //def json = libraryResource 'task-definition.json'

    def json = new JsonBuilder(data).toPrettyString()

    println json


    //def jsonslurper = new JsonSlurper()
    //jsonslurper.parseText(json)






}