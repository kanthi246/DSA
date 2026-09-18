package com.kanthi

/** Demonstrates longest-substring calculations. */
fun main(){
    val str = "kanthikirannalamati"
    println("Longest Substring:- ${lengthOfLongestSubstring(str)}")
    println("Longest Substring Chars:- ${printLongestSubString(str)}")
}

//fun LongestSubString  Count
/** Counts the longest substring without repeated characters. */
fun lengthOfLongestSubstring(s: String): Int {
    val map = mutableMapOf<Char, Int>()
    var left = 0
    var maxLength = 0
    for (right in s.indices) {
        val ch = s[right]
        if (map.containsKey(ch) && map[ch]!! >= left) {
            left = map[ch]!! + 1
        }
        map[ch] = right
        maxLength = maxOf(maxLength, right - left + 1)
    }
    return maxLength
}

//fun LongestSubStringWithoutRepeatingCharacters
/** Returns the longest substring without repeated characters. */
fun printLongestSubString(s: String): String {
    val map = mutableMapOf<Char, Int>()
    var left = 0
    var maxLength = 0
    var startIndex = 0
    for (right in s.indices) {
        val ch = s[right]
        if (map.containsKey(ch) && map[ch]!! >= left) {
            left = map[ch]!! + 1
        }
        map[ch] = right
        if (right - left + 1 > maxLength) {
            maxLength = right - left + 1
            startIndex = left
        }
    }
    return s.substring(startIndex, startIndex + maxLength)
}
