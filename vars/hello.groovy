#!/usr/bin/env groovy


def call(String name) {

    sh "echo hello $name"

    sh "../resources/hello-world.sh"

}