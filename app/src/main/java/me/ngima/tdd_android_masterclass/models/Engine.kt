package me.ngima.tdd_android_masterclass.models

class Engine(
    var temperature: Int = 15,
    var isTurnedOn: Boolean = false
) {


    fun turnOn() {
        isTurnedOn = true
        temperature = 95
    }

    fun turnOff() {
        isTurnedOn = false
        temperature = 15
    }
}