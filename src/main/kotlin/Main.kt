package com.pontotest

import com.pontotest.utils.basisPoints

fun main(args: Array<String>) {
    println("Hello World!")

    val a = 100f

    val bps = a.basisPoints(10);

    println("10 basis points of $a is: $bps")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}