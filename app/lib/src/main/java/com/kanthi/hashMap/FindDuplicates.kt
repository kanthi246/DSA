package com.kanthi.hashMap

/** Demonstrates duplicate detection with a set. */
fun main(){
    val array = intArrayOf(1, 2, 3, 4, 2, 5, 3)
    findFirstDuplicate(array)
    findDuplicates(array)
}

/** Prints values encountered more than once. */
fun findDuplicates(array: IntArray){
    val seen = mutableSetOf<Int>()
    val duplicate = mutableListOf<Int>()
    for(item in array){
        if(!seen.add(item)){ // this will "add item" in seen and return "true/false"
            duplicate.add(item)
        }
    }

    println("Duplicate $duplicate")
}

/** Prints the first repeated value, if one exists. */
fun findFirstDuplicate(array: IntArray){
    val seen = mutableSetOf<Int>()
    for(item in array){
        if(item in seen){
            println("First Duplicate $item")
            break
        }
        seen.add(item)
    }
}
