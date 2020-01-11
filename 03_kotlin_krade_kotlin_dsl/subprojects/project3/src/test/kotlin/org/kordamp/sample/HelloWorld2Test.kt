package org.kordamp.sample

import org.junit.Assert
import org.junit.Test

class HelloWorld2Test {

    @Test
    fun testSayHello() { // given:
        val hw = HelloWorld2()
        // when:
        val answer = hw.sayHello()
        // then:
        Assert.assertEquals(answer, "Hello World")
    }
    
}