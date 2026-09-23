package com.kanthi

import org.junit.After
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class BinarySearchTest {

    companion object {
        private lateinit var sharedSortedInput: IntArray

        // @BeforeClass runs once before this class's tests. @JvmStatic exposes the
        // companion method as the Java static method required by JUnit 4.
        @JvmStatic
        @BeforeClass
        fun setUpClass() {
            sharedSortedInput = intArrayOf(5, 6, 9, 10, 12, 15)
        }

        // @AfterClass runs once after all tests, even when a test fails.
        // A real shared resource (such as a server) would be closed here.
        @JvmStatic
        @AfterClass
        fun tearDownClass() {
            sharedSortedInput = intArrayOf()
        }
    }

    private lateinit var input: IntArray

    // @Before runs before EACH @Test. Copy to avoid sharing a mutable array.
    @Before
    fun setUp() {
        input = sharedSortedInput.copyOf()
    }

    // @After runs after EACH @Test, even when the assertion fails.
    // This reset is only a lifecycle example: JUnit creates a fresh instance per test.
    @After
    fun tearDown() {
        input = intArrayOf()
    }

    // @Test makes this method an independently reported test case.
    @Test
    fun `binary search when the target is found`() {
        val result = binarySearch(input, 9)

        // assertEquals(expected, actual) fails the test when values differ.
        assertEquals(9, result)
    }

    @Test
    fun `binary search when the target is not found`() {
        val result = binarySearch(input, 25)

        assertEquals(-1, result)
    }

    @Test
    fun `binary search when the input is null`() {
        // assertThrows checks both that an exception occurs and its type.
        val exception = assertThrows(NullPointerException::class.java) {
            binarySearch(null, 25)
        }

        assertEquals("Array is null", exception.message)
    }

    @Test
    fun `binary search when the input array is empty`() {
        val result = binarySearch(intArrayOf(), 25)

        assertEquals(-1, result)
    }
}
