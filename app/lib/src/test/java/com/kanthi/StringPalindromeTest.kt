package com.kanthi

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class StringPalindromeTest {

    @Test
    fun `isPalindrome returns true for a palindrome word`(){

        //arrange
        val input = "madam"

        //act
        val isPalindrome = isPalindrome(input)

        //assert
        assertTrue(isPalindrome)
    }

    @Test
    fun `isPalindrome returns false for a palindrome word`(){

        //arrange
        val input = "kanthi"

        //act
        val isPalindrome = isPalindrome(input)

        //assert
        assertFalse(isPalindrome)
    }

    @Test
    fun `isPalindrome returns false for null input`(){

        //arrange
        val input = null

        //act
        val isPalindrome = isPalindrome(input)

        //assert
        assertFalse(isPalindrome)
    }


    @Test
    fun `isPalindrome returns false for empty input`() {
        val result = isPalindrome("")

        assertFalse(result)
    }
}

