package com.pontotest.utils
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
