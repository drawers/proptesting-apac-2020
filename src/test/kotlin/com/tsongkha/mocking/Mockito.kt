package com.tsongkha.mocking

import com.nhaarman.mockitokotlin2.whenever
import io.kotest.core.spec.style.AnnotationSpec
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class Mockito : AnnotationSpec() {

    @Mock
    lateinit var mock: MutableList<String>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun mockito() {
        whenever(mock.get(0)).thenReturn("one")
        whenever(mock.get(1)).thenReturn("two")

        someCodeThatInteractsWithMock(mock)

        verify(mock).clear()
    }

    private fun someCodeThatInteractsWithMock(strings: MutableList<String>) {
        strings.clear()
    }
}