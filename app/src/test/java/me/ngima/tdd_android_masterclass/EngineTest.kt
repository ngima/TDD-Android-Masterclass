package me.ngima.tdd_android_masterclass

import me.ngima.tdd_android_masterclass.engine.Engine
import org.junit.Test

import org.junit.Assert.*

class EngineTest {

    private val engine = Engine(2000, 189, 15, false)

    @Test
    fun engineTurnsOn() {
        engine.turnOn()

        assertEquals(true, engine.isTurnedOn)
        assertEquals(95, engine.temperature)
    }

    @Test
    fun engineTurnsOff(){
        engine.turnOff()


        assertEquals(false, engine.isTurnedOn)
        assertEquals(15, engine.temperature)
    }
}