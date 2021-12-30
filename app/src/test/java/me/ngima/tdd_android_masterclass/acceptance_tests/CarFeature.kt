package me.ngima.tdd_android_masterclass.acceptance_tests

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import me.ngima.tdd_android_masterclass.models.Car
import me.ngima.tdd_android_masterclass.models.Engine
import org.junit.Test

class CarFeature {

    private val engine = Engine()
    private val car = Car(6.0, engine)

    @Test
    fun carIsLoosingFuelWhenItTurnsOn(){

        car.turnOn()

        assertEquals(5.5, car.fuel)
    }


    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature(){
        car.turnOn()

        assertEquals(95, car.engine.temperature)
        assertTrue( car.engine.isTurnedOn)
    }
}