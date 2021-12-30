package me.ngima.tdd_android_masterclass.models

class Car(var fuel: Double,
var engine: Engine) {

    fun turnOn() {
        fuel -= 0.5
        engine.turnOn()
    }
}