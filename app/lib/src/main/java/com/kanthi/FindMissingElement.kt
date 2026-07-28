package com.kanthi

fun main() {
    val arr = intArrayOf(1, 2, 3, 5, 6, 7, 8)
    println("Missing Element: ${findMissingElement(arr)}")
}

fun findMissingElement(arr: IntArray): Int {
    val l = arr.size + 1
    return (l * (l + 1) / 2) - arr.sum() //21-24
}