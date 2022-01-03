package me.ngima.tdd_android_masterclass.unit_tests

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import me.ngima.tdd_android_masterclass.models.Car
import me.ngima.tdd_android_masterclass.models.Engine
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class CarShould {

    private val engine: Engine = mock()
    private val car = Car(5.0, engine)

    @get:Rule
    var couroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenItTurnsOn() = runBlockingTest {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runBlockingTest {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}