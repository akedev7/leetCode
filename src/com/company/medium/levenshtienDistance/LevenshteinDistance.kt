package com.company.medium.levenshtienDistance

import java.util.Collections.min

fun main() {
    println(getLevenshteinDistance("abc", "yabd"))
}

typealias  NumberOfAction = Int

//Time : O(mn)
//Space : O(mn)
fun getLevenshteinDistance(str1: String, str2: String): NumberOfAction {
    val rowNum = str1.length + 1
    val columnNum = str2.length + 1
    val calculationList = MutableList(rowNum) { MutableList(columnNum) { 0 } }
    prepareTheList(rowNum, calculationList, columnNum)

    for (i in 1 until rowNum) {
        for (j in 1 until columnNum) {
            if (str1[i - 1] == str2[j - 1]) {
                calculationList[i][j] = calculationList[i - 1][j - 1]
            } else {
                calculationList[i][j] = min(listOf(calculationList[i - 1][j], calculationList[i][j - 1], calculationList[i - 1][j - 1])) + 1
            }
        }
    }
    return calculationList[rowNum - 1][columnNum - 1]
}

private fun prepareTheList(rowNum: Int, calculationList: MutableList<MutableList<Int>>, columnNum: Int) {
    var num1 = 0
    repeat(rowNum) { row ->
        calculationList[row][0] = num1++
    }

    var num2 = 0
    repeat(columnNum) { column ->
        calculationList[0][column] = num2++
    }
}
