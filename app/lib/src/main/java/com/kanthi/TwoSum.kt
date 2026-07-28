package com.kanthi

fun main(){
    val arr= intArrayOf(2,11,7,15,6,4)
    val target = 9
    //val result = twoSum(arr,target)
    val resultWithHashMao = twoSumWithHashMap(arr,target)
    //println("TargetElements:- ${result.contentToString()}")
    println("TargetElements:- ${resultWithHashMao.contentToString()}")
}

//for two sum with two pointer approach the array should be sorted else it will not work
fun twoSum(arr: IntArray, target: Int):IntArray {
    var left = 0
    var right = arr.size - 1
    arr.sort()
    println(arr.contentToString())
    while(left < right){
        val sum = arr[left] + arr[right]
        when{
            sum == target -> return intArrayOf(left,right)
            sum < target -> left++
            else -> right--
        }
    }
    return intArrayOf()
}

//with hashmap it doesn't matter if the array is sorted or not
fun twoSumWithHashMap(arr: IntArray, target: Int):IntArray{
    val map = HashMap<Int,Int>()
    for(index in arr.indices){
        val match = target - arr[index]
        println("Match:- $match")
        if(map.containsKey(match)){
            return intArrayOf(map[match]!!,index)
        }
        map[arr[index]] = index
    }
    return intArrayOf()
}