package com.tsongkha.max

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.nulls.shouldBeNull

class ValueBased : AnnotationSpec() {

    @Test
    fun largestValue() {
        val ints = listOf(4, 8, 7)

        ints.myMax()!!.shouldBeEqualComparingTo(8)
    }

    @Test
    fun largestValueReverse() {
        val ints = listOf(7, 8, 4)

        ints.myMax()!!.shouldBeEqualComparingTo(8)
    }

    @Test
    fun empty() {
        val ints = emptyList<Int>()

        ints.myMax().shouldBeNull()
    }
}