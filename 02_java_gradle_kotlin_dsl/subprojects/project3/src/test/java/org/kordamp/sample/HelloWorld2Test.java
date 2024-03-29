/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2022 Urs Joss.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kordamp.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HelloWorld2Test {
    @Test
    void testSayHello() {
        // given:
        HelloWorld2 hw = new HelloWorld2();

        // when:
        String answer = hw.sayHello();

        // then:
        assertEquals(answer, "Hello World");
    }
}