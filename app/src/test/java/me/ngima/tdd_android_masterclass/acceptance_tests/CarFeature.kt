package me.ngima.tdd_android_masterclass.acceptance_tests

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import me.ngima.tdd_android_masterclass.models.Car
import me.ngima.tdd_android_masterclass.models.Engine
import org.junit.Rule
import org.junit.Test

class CarFeature {

    private val engine = Engine()
    private val car = Car(6.0, engine)

    @get:Rule
    var couroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() = runBlockingTest{

        car.turnOn()

        assertEquals(5.5, car.fuel)
    }


    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperatureGradually() = runBlockingTest{
        car.turnOn()

        couroutinesTestRule.advanceTimeBy(2001)
        assertEquals(25, car.engine.temperature)

        couroutinesTestRule.advanceTimeBy(2000)
        assertEquals(50, car.engine.temperature)

        couroutinesTestRule.advanceTimeBy(2000)
        assertEquals(95, car.engine.temperature)

        assertTrue( car.engine.isTurnedOn)
    }
}