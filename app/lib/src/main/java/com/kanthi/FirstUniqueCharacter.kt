package com.kanthi

fun main(){

    //println("First Unique Character:- ${firstUniqueCharacter("kanthi")}")
    println("First Unique Character:- ${firstUniqueCharacter("loveleetcode")}")

}

fun firstUniqueCharacter(s: String): Int {
    val map = HashMap<Char,Int>()
    for(char in s){
        map[char] = map.getOrDefault(char,0) + 1
    }
    for(i in s.indices){
        if(map[s[i]] == 1) return i
    }
    return -1
}