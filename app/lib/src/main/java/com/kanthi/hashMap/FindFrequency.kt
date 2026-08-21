package com.kanthi.hashMap

fun main(){
    val array = intArrayOf(1, 2, 3, 2, 4, 1, 5, 2)
    findFrequencyOfEachNo(array)
}

fun findFrequencyOfEachNo(array: IntArray){
    val map = mutableMapOf<Int,Int>()
    for(i in array){
        map[i] = map.getOrDefault(i,0) + 1
    }

    println("Frequency ${map.entries}")
    //Frequency [1=2, 2=3, 3=1, 4=1, 5=1]

    val result = map.maxByOrNull { it.value }?.key
    println("Repeated Key $result") //print the most repeated key

    val topTwo = map.entries.sortedByDescending { it.value }.take(2)  //Top 2
    //Frequency calculation → O(n)
    //Sorting              → O(k log k)
    //take(2)              → O(1)
    println("Top Two Freq $topTwo")

    //find the first number that appears only once
    var value: Int? = null
    for (i in array) {
        if (map[i] == 1) {
            value = i
            break
        }
    }
    println("The first number that appears only once: $value")
}

