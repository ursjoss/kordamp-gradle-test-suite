/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020 Anonymous.
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
package org.kordamp.sample

class ClassUnderTest private constructor() {
    companion object {
        // called from project1 integrationTest
        fun method1(): String = "method1"

        // called from project2 integrationTest
        fun method2(): String = "method2"

        // called from project3 functionalTest
        fun method3(): String = "method3"
    }
}
