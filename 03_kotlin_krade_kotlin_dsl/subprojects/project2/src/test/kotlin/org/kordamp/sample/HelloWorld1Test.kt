package org.kordamp.sample

import org.junit.Assert
import org.junit.Test

class HelloWorld1Test {
    @Test
    fun testSayHello() { // given:
        val hw = HelloWorld1()
        // when:
        val answer: String = hw.sayHello()
        // then:
        Assert.assertEquals(answer, "Hello World")
    }
}