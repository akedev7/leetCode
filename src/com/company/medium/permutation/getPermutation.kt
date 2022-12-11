package com.company.medium.permutation

fun main() {
    getPermutation(listOf(1, 2, 3)).forEach {
        println(it)
    }

    println("---------")
    getPermutationV2(listOf(1, 2, 3)).forEach {
        println(it)
    }
}

fun getPermutation(inputList: List<Int>): List<List<Int>> {
    val totalList = mutableListOf<List<Int>>()
    permutationHelper(mutableListOf(), inputList, totalList)
    return totalList
}

fun getPermutationV2(inputList: List<Int>): List<List<Int>> {
    val totalList = mutableListOf<List<Int>>()
    permutationHelperV2(0, inputList.toMutableList(), totalList)
    return totalList
}

private fun permutationHelper(permutationList: List<Int>, leftArray: List<Int>, totalList: MutableList<List<Int>>) {
    if (leftArray.isEmpty()) {
        totalList.add(permutationList)
        return
    }

    for (i in leftArray) {
        val newArray = leftArray.remove(i)
        permutationHelper(permutationList.add(i), newArray, totalList)
    }
}

private fun permutationHelperV2(i: Int, array: MutableList<Int>, totalList: MutableList<List<Int>>) {
    if (i == array.size - 1) {
        totalList.add(ArrayList(array))
    } else {
        for (j in i until array.size) {
            array.swap(i, j)
            permutationHelperV2(i + 1, array, totalList)
            array.swap(i, j)
        }
    }
}

private fun MutableList<Int>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}


private fun <E> List<E>.add(element: E): List<E> {
    val mutateList = this.toMutableList()
    mutateList.add(element)
    return mutateList.toList()
}

private fun <E> List<E>.remove(element: E): List<E> {
    return this.filter { it != element }.map {
        it
    }.toList()
}
