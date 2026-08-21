package com.kanthi.hashMap

fun main(){
    val arr= intArrayOf(2,11,7,15,6,4)
    val target = 9
    println("TargetElements:- ${twoSumWithHashMap(arr,target).contentToString()}")
}

fun twoSumWithHashMap(arr: IntArray, target: Int): IntArray {
    val map = hashMapOf<Int, Int>()
    for (i in arr.indices) {
        val match = target - arr[i]
        if (map.containsKey(match)) {
            return intArrayOf(map[match]!!, i)
        }

        map[arr[i]] = i
    }
    return intArrayOf()
    //Time: O(n) (arr.sum() has to visit each element to add)
    //Space: O(n) (you only use one extra variable)
    // Approach :- Hashmap
}