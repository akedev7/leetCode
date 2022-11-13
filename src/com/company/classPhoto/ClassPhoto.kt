package com.company.classPhoto


fun main() {

    val redShirts = intArrayOf(5, 8, 1, 3, 4)
    val blueShirt = intArrayOf(6, 9, 2, 4, 5)

    println(canClassPhotoTaken(redShirts, blueShirt))

}

fun canClassPhotoTaken(redShirts: IntArray, blueShirt: IntArray): Boolean {
    redShirts.sortDescending()
    blueShirt.sortDescending()

    return if (redShirts.first() > blueShirt.first()) {
        checkIfValidClassPhoto(redShirts, blueShirt)
    } else {
        checkIfValidClassPhoto(blueShirt, redShirts)
    }
}

private fun checkIfValidClassPhoto(redShirts: IntArray, blueShirt: IntArray): Boolean {
    redShirts.forEachIndexed { index, it ->
        if (it <= blueShirt[index]) {
            return false
        }
    }
    return true
}

