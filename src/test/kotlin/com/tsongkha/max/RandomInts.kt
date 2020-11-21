package com.tsongkha.max

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.ParametersSuppliedBy
import org.junit.experimental.theories.PotentialAssignment
import kotlin.random.Random

@Retention(AnnotationRetention.RUNTIME)
@ParametersSuppliedBy(RandomIntSupplier::class)
annotation class RandomInts(val iterations: Int = 50, val seed: Int = 0)

class RandomIntSupplier : ParameterSupplier() {

    private val STOP_THRESHOLD = 0.9

    override fun getValueSources(sig: ParameterSignature?): MutableList<PotentialAssignment> {
        val annotation = requireNotNull(sig).getAnnotation(RandomInts::class.java)

        val rng = Random(annotation.seed)

        return generateSequence { randomInts(rng) }
            .take(annotation.iterations)
            .map {
                PotentialAssignment.forValue("ints", it)
            }
            .toMutableList()
    }

    private fun randomInts(rng: Random): List<Int> {
        return generateSequence { rng.nextInt() }.takeWhile { rng.nextDouble() < STOP_THRESHOLD }.toList()
    }
}