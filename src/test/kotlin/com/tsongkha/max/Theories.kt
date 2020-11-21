package com.tsongkha.max

import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assumptions.assumeThat
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class JUnitTheoryDataPoints {

    companion object {

        @DataPoints
        @JvmField
        val intPoints: List<List<Int>> = listOf(
            listOf(
                1, 2, 3, 4, 5
            ),
            listOf(
                10, 99, 20
            ),
            listOf(
                5, 4, 3, 2, 1
            ),
            emptyList()
        )
    }

    @Theory
    fun noElementsGreaterThanMyMax(
        ints: List<Int>
    ) {
        assumeThat(ints).isNotEmpty

        val myMax = ints.myMax()!!
        ints.forEach {
            it.shouldBeLessThanOrEqual(myMax)
        }
    }

    @Theory
    fun myMaxIsInTheCollection(ints: List<Int>) {
        assumeThat(ints).isNotEmpty

        assertThat(ints).contains(ints.myMax())
    }

    @Theory
    fun emptyIsNull(ints: List<Int>) {
        assumeThat(ints).isEmpty()

        assertThat(ints).isNull()
    }

//    @Theory
//    fun emptyIsNull(@RandomInts(iterations = 100, seed = 0) ints: List<Int>) {
//        assumeThat(ints).isEmpty()
//
//        assertThat(ints).isNull()
//    }
}