package com.tsongkha.max

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.ints.shouldNotBeGreaterThan
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.property.checkAll

class PropertyBasedNaive : StringSpec() {

    init {
        "no elements greater than myMax" {
            checkAll<List<Int>> { ints ->
                val myMax = ints.myMax() ?: return@checkAll

                ints.forEach {
                    it shouldNotBeGreaterThan myMax
                }
            }
        }

        "myMax is in the collection" {
            checkAll<List<Int>> { ints ->
                val myMax = ints.myMax() ?: return@checkAll

                ints shouldContain myMax
            }
        }

        "empty is null" {
            checkAll<List<Int>> { ints ->
                if (ints.isNotEmpty()) return@checkAll

                ints.myMax().shouldBeNull()
            }
        }
    }
}