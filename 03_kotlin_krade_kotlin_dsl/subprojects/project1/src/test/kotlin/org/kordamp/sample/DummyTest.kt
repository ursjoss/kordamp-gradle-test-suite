package org.kordamp.sample

import org.junit.Assert.assertEquals
import org.junit.Test

class DummyTest {

    // without this dummy test, gradlew jacocoRootReport would fail
    @Test
    fun dummyTest() {
        assertEquals(true, true)
    }
}