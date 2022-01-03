package me.ngima.tdd_android_masterclass.models

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Car(
    var fuel: Double,
    var engine: Engine
) {

    fun turnOn() {
        fuel -= 0.5
        CoroutineScope(Dispatchers.Main).launch {
            engine.turnOn()
        }
    }
}