package com.kanthi

fun main() {
    val arr = intArrayOf(1, 2, 3, 5, 6, 7, 8)
    println("Missing Element: ${findMissingElement(arr)}")
    println("Missing Element Using Hash: ${findMissingItemUsingSet(arr)}")
}

fun findMissingElement(arr: IntArray): Int {
    val n = arr.size + 1
    return (n * (n + 1) / 2) - arr.sum() //21-24

//    * Time: O(n) (arr.sum() has to visit each element to add)
//    * Space: O(1) (you only use one extra variable)
    // Approach :- Mathematical / Formula approach
}

fun findMissingItemUsingSet(array: IntArray):Int {
    var missingElement = 0
    val set = array.toHashSet()
    for(i in 1..array.size+1){
        if(i !in set){
            missingElement =  i
            break
        }
    }
    return missingElement

    //    * Time: O(n) (arr.sum() has to visit each element to add)
//    * Space: O(n) (you only use one extra variable)
    // Approach :- Hashing
}

//Note :- even if we create a new method to add all the
// elements the time complexity is still 0(n)
//Because it still needs to visit all values to add
fun addAllElements(arr: IntArray):Int{
     var value = 0
    for(item in arr){
        value += item
    }
    return value
}