package com.pontotest.utils

import java.util.Calendar
import java.util.TimeZone

/**
 * Computes the percentage specified in bps from this amount object
 */
private inline fun <T> basisPoints(
    amount: T,
    bps: Long,
    multiply: T.(value: Long) -> T,
    divide: T.(value: Long) -> T
): T =
    (amount.multiply(bps)).divide(10000)

/**
 * @see basisPoints<T>
 */
infix fun Float.basisPoints(bps: Long): Float =
    basisPoints<Float>(
        this,
        bps,
        Float::times,
        Float::div
    )


fun isWeekday(day: Int): Boolean {
    return when (day) {
        1, 2, 3, 4, 5 -> true
        else -> false
    }
}


// Function to check if the given year is a leap year
fun isLeapYear(year: Int): Boolean {
    return if (year % 4 == 0) {
        if (year % 100 == 0) {
            year % 400 == 0
        } else {
            true
        }
    } else {
        false
    }
}

// Function to check if the timestamp is during the day
fun isDayTime(timestamp: Long): Boolean {
    val cal = Calendar.getInstance()
    cal.timeInMillis = timestamp
    return cal.get(Calendar.HOUR_OF_DAY) in 9..17
}

enum class TimeOfDay {
    MORNING,
    AFTERNOON,
    NIGHT
}

fun getTimeOfDay(timestamp: Long): TimeOfDay {
    val cal = Calendar.getInstance()
    cal.timeZone = TimeZone.getTimeZone("PST")
    cal.timeInMillis = timestamp
    return when (cal.get(Calendar.HOUR_OF_DAY)) {
        in 6..11 -> TimeOfDay.MORNING
        in 12..16 -> TimeOfDay.AFTERNOON
        else -> TimeOfDay.NIGHT
    }
}



