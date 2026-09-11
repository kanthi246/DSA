package com.kanthi

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test

class BinarySearchTest {

    var input : IntArray? = null

    @Before
    fun setup(){
        input = intArrayOf(10,12,6,5,9,15)
    }

    @Test
    fun `binary search when the target is found`(){

        val target = 9

        val isBinary = binarySearch(input,target)


        assertEquals(9,isBinary)

    }

    @Test
    fun `binary search when the target is not found`(){

        val target = 25

        val isBinary = binarySearch(input,target)

        assertEquals(-1,isBinary)

    }

    @Test
    fun `binary search when the input is null`(){


        val exception = assertThrows(NullPointerException::class.java){
            binarySearch(null,25)
        }

        assertEquals("Array is null",exception.message)

    }

    @Test
    fun `binary search when the input array is empty`(){

        val target = 25

        val isBinary = binarySearch(intArrayOf(),target)

        assertEquals(-1,isBinary)

    }

}