package com.kanthi

fun main() {

    val arr = intArrayOf(1, 3, 9, 5, 7, 11)

    println("LargestElement:-${findLargestElement(arr)}")
    println("SecondLargestElement:-${findSecondLargestElement(arr)}")
}

fun findLargestElement(arr: IntArray): Int {
    var largest = arr[0]
    for (i in 1 until arr.size) {
        if (arr[i] > largest) {
            largest = arr[i]
        }
    }
    return largest
}

fun findSecondLargestElement(arr: IntArray): Int {
    var largest = arr[0]
    var secondLargest = Int.MIN_VALUE
    for (i in 1 until arr.size) {
        if (arr[i] > largest) {
            secondLargest = largest
            largest = arr[i]
        } else if (arr[i] > secondLargest && arr[i] != largest) {
            secondLargest = arr[i]
        }
    }
    return secondLargest
}