package me.ngima.tdd_android_masterclass.unit_tests

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import me.ngima.tdd_android_masterclass.models.Engine
import org.junit.Rule
import org.junit.Test

class EngineShould {

    private val engine = Engine()

    @get:Rule
    var couroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun turnOn() = runBlockingTest{
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun temperatureIncreasesWhenItsTurnOn() = runBlockingTest{
        val flow = engine.turnOn()

        val actual = flow.toList()

        assertEquals(listOf(25, 50, 95), actual)
    }
}