package me.ngima.tdd_android_masterclass.models

import android.util.Log
import kotlinx.coroutines.delay

class Engine(
    var temperature: Int = 15,
    var isTurnedOn: Boolean = false
) {


    suspend fun turnOn() {
        isTurnedOn = true

        delay(6000)

        temperature = 95

        Log.d("COURSE", "Engine has turned on")
    }

    fun turnOff() {
        isTurnedOn = false
        temperature = 15
    }
}