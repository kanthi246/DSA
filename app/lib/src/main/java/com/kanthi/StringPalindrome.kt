package com.kanthi

/** Demonstrates string and number palindrome checks. */
fun main(){
    println("IsPalindrome:-${isPalindrome("kanthi")}")
    println("IsPalindromeNumber:-${isPalindromeNumber(121)}")
}

/** Checks whether a nonempty string reads the same in both directions. */
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

/** Checks whether the decimal digits of [x] form a palindrome. */
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
