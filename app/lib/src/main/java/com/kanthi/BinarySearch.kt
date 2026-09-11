package com.kanthi

fun main(){
    val array = intArrayOf(2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91)
    val target = 45
    println("Binary Search:- ${binarySearch(array,target)}")
}

fun binarySearch(array: IntArray?, target: Int): Any {

    array?.let { list ->
        var left = 0
        var right = list.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2   // see note below on why this form is used

            when {
                list[mid] == target -> return list[mid]
                list[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
    }

    return if(array==null) throw NullPointerException("Array is null") else -1   // target not found
// Time: O(log n) — you eliminate half the  search space every iteration, so you never visit most elements
// Space: O(1) — only left, right, mid variables used, no extra structure
    // Approach :- Two Pointer Traversal
}
