#!/usr/bin/env groovy
@Grab('org.yaml:snakeyaml:1.17')
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder
import org.yaml.snakeyaml.Yaml

def call(String name) {

    sh "echo hello $name"

    def script = libraryResource 'hello-world.sh'

    writeFile encoding: 'UTF-8', file: 'hello-script.sh', text: script

    sh "chmod 755 hello-script.sh && ./hello-script.sh"


    def yaml = libraryResource 'test.yml'


    Yaml parser = new Yaml()
    Map<String, String> example = parser.load(yaml)

    List newList = new ArrayList()

    def jsonslurper = new JsonSlurper()
    def task_json = jsonslurper.parseText(task_def)

    for (m in example)
    {
        task_json.path1.path2.arrEle << ["key": m.key, "value": m.value ]
    }

    println task_json





}