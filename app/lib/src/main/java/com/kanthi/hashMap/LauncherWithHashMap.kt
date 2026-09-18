package com.kanthi.hashMap

/** Demonstrates frequency counting for app names. */
fun main(){

     val array = arrayOf("WhatsApp","Instagram", "WhatsApp" , "Chrome" , "Instagram" , "WhatsApp")

    val result = findFrequency(array)
    println("FindFrequency of $result")
    takeTopTwo(result)
}

/** Counts how often each string occurs in [array]. */
fun findFrequency(array: Array<String>): MutableMap<String,Int> {
    val map = mutableMapOf<String,Int>()

    for(i in array){
        map[i] = map.getOrDefault(i,0) + 1
    }

    return map
}

/** Prints the two entries with the highest counts. */
fun takeTopTwo(array: MutableMap<String, Int>) {

    val result =  array.entries.sortedByDescending { it.value }.take(2)

    println("Top Two items $result")
}




