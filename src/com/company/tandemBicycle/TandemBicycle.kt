package com.company.tandemBicycle


fun main() {
    val redShirtSpeeds = intArrayOf(5, 5, 3, 9, 2)
    val blueShirtSpeeds = intArrayOf(3, 6, 7, 2, 1)
    val fastest = true
    println(getTandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest))

}

fun getTandemBicycle(redShirtSpeeds: IntArray, blueShirtSpeeds: IntArray, fastest: Boolean): Int {
    redShirtSpeeds.sortDescending()
    blueShirtSpeeds.sort()
    if (fastest) {
        return getMaximumOrMinimum(redShirtSpeeds, blueShirtSpeeds) { first, second -> first > second}
    }
    return getMaximumOrMinimum(redShirtSpeeds, blueShirtSpeeds) { first, second -> first < second}
}

private fun getMaximumOrMinimum(redShirtSpeeds: IntArray, blueShirtSpeeds: IntArray, condition: (Int, Int) -> Boolean) =
        redShirtSpeeds.mapIndexed { index, it ->
            if (condition(it, blueShirtSpeeds[index])) {
                it
            } else {
                blueShirtSpeeds[index]
            }
        }.sum()
