package com.company.medium.minHeapConstruction

import kotlin.math.floor

fun main() {
    getMinHeap(mutableListOf(30, 102, 23, 17, 18, 9, 44, 12, 31)).forEach { print("$it,") }
}

fun getMinHeap(inputList: MutableList<Int>): MutableList<Int> {
    val lastParentPosition: Int = floor(((inputList.size - 2) / 2).toDouble()).toInt()
    for (i in lastParentPosition downTo 0) {
        inputList.siftDown(i)
    }
    return inputList
}

private fun MutableList<Int>.siftDown(parentPosition: Int) {
    var currentParent: Int? = parentPosition
    while (currentParent != null) {
        val firstChildPosition = (currentParent * 2) + 1
        val secondChildPosition = (currentParent * 2) + 2
        currentParent = if ((firstChildPosition < this.size && secondChildPosition < this.size) && (this[currentParent] > this[firstChildPosition] || this[currentParent] > this[secondChildPosition])) {
            if (this[firstChildPosition] < this[secondChildPosition]) {
                this.swapPosition(currentParent, firstChildPosition)
                firstChildPosition
            } else {
                this.swapPosition(currentParent, secondChildPosition)
                secondChildPosition
            }
        } else {
            null
        }
    }
}

private fun MutableList<Int>.swapPosition(first: Int, second: Int) {
    val temp = this[first]
    this[first] = this[second]
    this[second] = temp
}



