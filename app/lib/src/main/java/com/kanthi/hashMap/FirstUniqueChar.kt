package com.kanthi.hashMap

fun main(){
    val value  = "swiss"
    findFirstNonRepeatingChar(value)
}

fun findFirstNonRepeatingChar(value: String) {
    val char = value.toCharArray()
    val map = mutableMapOf<Char,Int>()

    for(i in char){
        map[i] = map.getOrDefault(i,0) + 1
    }

    println(map)

    val result = map.entries.sortedBy { it.value }.take(1)
    println(result)

    //Time = O(n)
    //Space = O(k)
    //k = number of unique characters.
}