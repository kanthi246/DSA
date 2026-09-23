package com.kanthi.extensionfun

fun main(){

    println("Nalamati Kanthi Kiran".getInitials())

}

fun String.getInitials(): String {

    //to get the value we need to use this

    return this.split(" ").map { it.first() }.joinToString("")
}