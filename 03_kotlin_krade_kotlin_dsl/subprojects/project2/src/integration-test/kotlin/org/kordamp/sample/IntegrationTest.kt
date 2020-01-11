package org.kordamp.sample

import org.junit.Assert.assertEquals
import org.junit.Test

class IntegrationTest {
    @Test
    fun integration() {
        assertEquals("method1", ClassUnderTest.method1())
    }
}