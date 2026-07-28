package com.kanthi

fun main(){
    println("IsPalindrome:-${isPalindrome("kanthi")}")
    println("IsPalindromeNumber:-${isPalindromeNumber(121)}")
}

fun isPalindrome(value: String):Boolean{
    var left = 0
    var right = value.length - 1
    while(left < right){
        if(value[left] != value[right]){
            return false
        }
        left++
        right--
    }
    return true
}

fun isPalindromeNumber(x: Int): Boolean {
    val str = x.toString()
    var left = 0
    var right = str.length - 1

    while (left < right) {
        if (str[left] != str[right]) {
            return false
        }
        left++
        right--
    }

    return true
}
