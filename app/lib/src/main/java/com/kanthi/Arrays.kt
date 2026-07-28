package com.kanthi

fun main() {
    val array = intArrayOf(10, 20, 30, 110, 50)

//    println(" Array Item: ${array[2]}")
//
//    array[0] = 100
//    println(" Item Update: ${array[0]}")
//
//    //traverse(Visit every element) array elements using for loop
//    for (item in array) {
//        println(" Array Item: $item")
//    }

    println("Largest Element: ${findLargest(array)}")

    println("Second Element: ${findSecondLargest(array)}")

    println("Move Zero to End: ${moveZeros(intArrayOf(1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0)).contentToString()}")
}

//find the largest element in an array
fun findLargest(array: IntArray): Int {
    var largest = array[0]
    for (item in array) {
        if (item > largest) {
            largest = item
        }
    }
    return largest
//    * Time: O(n) (you visit each element once)
//    * Space: O(1) (you only use one extra variable)
}

//find the Second largest element in an array
fun findSecondLargest(array: IntArray): Int {
    var firstLargest = array[0] //10
    var secondLargest = Int.MIN_VALUE
    for (item in array) {
        if (item > firstLargest) {
            secondLargest = firstLargest
            firstLargest = item
        } else if (item > secondLargest && item != firstLargest) {
            secondLargest = item
        }
    }
    return secondLargest
//    * Time: O(n) (you visit each element once)
//    * Space: O(1) (you only have two extra variable)
}

//move all the zeros to end
fun moveZeros(array: IntArray): IntArray {
    var zero = 0
    for(i in array.indices){
        if(array[i] != 0){
            array[zero] = array[i]
            zero++
        }
    }
    while(zero<array.size) {
        array[zero] = 0
        zero++
    }
    return array
//    * Time: O(n) (you visit each element once)
//    * Space: O(1) (you only have two extra variable)
}
