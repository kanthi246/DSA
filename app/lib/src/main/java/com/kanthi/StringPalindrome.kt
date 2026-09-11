package com.kanthi

fun main(){
    println("IsPalindrome:-${isPalindrome("kanthi")}")
    println("IsPalindromeNumber:-${isPalindromeNumber(121)}")
}

fun isPalindrome(value: String?):Boolean{

    if (value.isNullOrEmpty()) return false

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

    //Time: O(n) (arr.sum() has to visit each element to add)
    //Space: O(1) (you only use one extra variable)
    // Approach :- Two Pointer
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


    //Time: O(n) (arr.sum() has to visit each element to add)
    //Space: O(1) (you only use one extra variable)
    // Approach :- Two Pointer
}
