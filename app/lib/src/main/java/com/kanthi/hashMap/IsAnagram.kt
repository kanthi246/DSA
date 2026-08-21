package com.kanthi.hashMap

fun main(){
    println("IsAnagram ${isAnagram("silent","listen")}")
}

fun isAnagram(s1: String,s2: String) : Boolean{
    val map = mutableMapOf<Char, Int>()

    if(s1.length!=s2.length) return false

    for (ch in s1){
        map[ch] = map.getOrDefault(ch,0) + 1
    }

    //l -> 1
    //i -> 1
    //s -> 1
    //t -> 1
    //e -> 1
    //n -> 1

    for (ch in s2){
        map[ch] = map.getOrDefault(ch,0) - 1
    }

    //l -> 1
    //i -> 0
    //s -> 0
    //t -> 1
    //e -> 1
    //n -> 1
    // in the second loop we're passing the ch which is a Key
    // so it'll find from the map so after it finds it'll change
    // that to 0 so at the end all values becomes 0

    return map.values.all {it==0}
}