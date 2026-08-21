package com.kanthi

fun main() {
    val array = intArrayOf(1, 9, 8, 4, 0, 0, 2, 7)

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

    println("Reverse array :- ${reverseArray(array).contentToString()}")

    println("Move Zero to End: ${moveZeros(array).contentToString()}")

    println("Find the Sub Array: ${subArray(array)}")

}


//reverse the array
fun reverseArray(arr: IntArray) : IntArray {
    var left = 0
    var right = arr.size -1
    while(left < right){
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
        left++
        right--
    }
    return arr
//    * Time: O(n) (you visit each element once)
//    * Space: O(1) (you only use one extra variable)
    // Approach :- Two Pointer Traversal
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
    // Approach :- Array Traversal
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
    // Approach :- Array Traversal
}

//move all the zeros to end
fun moveZeros(array: IntArray) : IntArray {
    var i = 0
    for(item in array){
        if(item != 0){
            array[i] = item
            i++
        }
    }
    while(i<array.size){
        array[i] = 0
        i++
    }
    return array
//    * Time: O(n) (you visit each element once)
//    * Space: O(1) (you only have two extra variable)
    // Approach :- Two Pointer Traversal
}

fun subArray(array: IntArray): Int {
    var current = array[0]
    var max = array[0]
    for (i in 1 until array.size) {
        current = maxOf(array[i], current + array[i])
        max = maxOf(max, current)
    }
    return max
//    * Time: O(n) (you visit each element once)
//    * Space: O(1) (you only have two extra variable)
    // Approach :- Kadane's Algorithm
}
