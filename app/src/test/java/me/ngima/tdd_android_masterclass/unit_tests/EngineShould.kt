package me.ngima.tdd_android_masterclass.unit_tests

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import me.ngima.tdd_android_masterclass.models.Engine
import org.junit.Test

class EngineShould {

    private val engine = Engine()


    @Test
    fun turnOn() {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun temperatureIncreasesWhenItsTurnOn(){
        engine.turnOn()

        assertEquals(95, engine.temperature)
    }
}