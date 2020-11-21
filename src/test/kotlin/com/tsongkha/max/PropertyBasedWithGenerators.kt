package com.tsongkha.max

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldNotBeGreaterThan
import io.kotest.property.Arb
import io.kotest.property.PropertyTesting
import io.kotest.property.arbitrary.default
import io.kotest.property.arbitrary.filter
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.exhaustive
import io.kotest.property.forAll

class PropertyBasedWithGenerators : StringSpec() {

    private val nonEmptyLists = Arb.default<List<Int>>().filter { it.isNotEmpty() }

    private val emptyLists = listOf(emptyList<Int>()).exhaustive()

    init {
        PropertyTesting.shouldPrintShrinkSteps = true
        PropertyTesting.shouldPrintGeneratedValues = true

        "no elements greater than myMax" {
            checkAll(nonEmptyLists) { ints ->
                val myMax = ints.myMax()!!

                ints.forEach {
                    withClue("Element of list should not be greater than myMax") {
                        it shouldNotBeGreaterThan myMax
                    }
                }
            }
        }

        "myMax is in the collection" {
            forAll(nonEmptyLists) { ints ->
                val myMax = ints.myMax()!!

                ints.contains(myMax)
            }
        }

        "empty is null" {
            forAll(emptyLists) { ints ->
                ints.myMax() == null
            }
        }
    }
}