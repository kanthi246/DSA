package com.kanthi

fun main(){
    val arr = intArrayOf(1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0)
    println("Original Array: ${arr.contentToString()}")
    val result = moveZeroToEnd(arr)
    println("Modified Array: ${result.contentToString()}")
}

fun moveZeroToEnd(arr: IntArray):IntArray{
    var w = 0
    for(r in arr.indices){
        if(arr[r] != 0){
            arr[w] = arr[r]
            w++
        }
    }
    while(w < arr.size){
        arr[w] = 0
        w++
    }
    return arr
}