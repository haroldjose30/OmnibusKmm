package dev.haroldjose.ominibus

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}