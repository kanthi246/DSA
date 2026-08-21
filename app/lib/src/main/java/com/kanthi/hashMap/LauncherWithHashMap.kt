package com.kanthi.hashMap

fun main(){

     val array = arrayOf("WhatsApp","Instagram", "WhatsApp" , "Chrome" , "Instagram" , "WhatsApp")

    val result = findFrequency(array)
    println("FindFrequency of $result")
    takeTopTwo(result)
}

fun takeTopTwo(array: HashMap<String, Int>) {

     val result =  array.entries.sortedByDescending { it.value }.take(2)

    println("Top Two items $result")
}


fun findFrequency(array: Array<String>): HashMap<String,Int> {
    val map = HashMap<String,Int>()

    for(item in array){
        map[item] = map.getOrDefault(item,0) + 1
    }

    return map
}


