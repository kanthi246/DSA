package com.kanthi

fun main(){
println("Longest Palindrome:- ${longestPalindrome("banana")}")
}

fun longestPalindrome(s: String): String {
    if (s.isEmpty()) return ""
    var start = 0
    var end = 0
    for (i in s.indices) {
        val len1 = expand(s, i, i)       // Odd length
        val len2 = expand(s, i, i + 1)   // Even length
        val len = maxOf(len1, len2)
        if (len > end - start + 1) {
            start = i - (len - 1) / 2
            end = i + len / 2
        }
    }
    return s.substring(start, end + 1)
}

private fun expand(s: String, left: Int, right: Int): Int {
    var l = left
    var r = right
    while (l >= 0 && r < s.length && s[l] == s[r]) {
        l--
        r++
    }
    return r - l - 1

}