package org.kordamp.sample

import org.junit.Assert.assertEquals
import org.junit.Test

class FunctionalTest {
    @Test
    fun integration() {
        assertEquals("method2", ClassUnderTest.method2())
    }
}