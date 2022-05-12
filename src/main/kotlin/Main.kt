package com.pontotest

import com.pontotest.utils.basisPoints
import com.pontotest.utils.getTimeOfDay
import java.util.Calendar

fun parseArg(arg: String): String {
    return when (arg) {
        "--timeOfDay" -> getTimeOfDay(Calendar.getInstance().timeInMillis).name
        else -> "BPS it is"
    }
}


fun main(args: Array<String>) {
    println("Hello World!")

    val toPrint = parseArg(args[0])

    println(toPrint)

    val a = 100f

    val bps = a.basisPoints(10);

    println("10 basis points of $a is: $bps")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}
