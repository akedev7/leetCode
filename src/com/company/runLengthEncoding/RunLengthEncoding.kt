package com.company.runLengthEncoding

fun main() {
    println(getRunLengthEncoding("AAAAAAAAAAAAABBCCCCDDABC"))
}

fun getRunLengthEncoding(inputString: String): String {
    val list = mutableListOf<Any>()
    var count = 1
    for (i in 1 until inputString.count()) {
        if (inputString[i] != inputString[i - 1] || count == 9) {
            list.add(inputString[i - 1])
            list.add(count)
            count = 1
        } else {
            count++
        }
    }

    return list.joinToString(separator = "")
}
