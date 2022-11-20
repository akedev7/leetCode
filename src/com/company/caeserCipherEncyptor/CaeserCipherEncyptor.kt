package com.company.caeserCipherEncyptor

fun main() {
    println(getCaeserCipher("xyz", 2))
    println(getCaeserCipherV2("xyz", 2))

}

fun getCaeserCipher(str: String, nums: Int): String {
    return str.map {
        var sumCode = it.code + nums
        while (sumCode > 122) {
            sumCode -= 26
        }
        Char(sumCode)
    }.joinToString (separator = "")
}


fun getCaeserCipherV2(str: String, nums: Int): String {
    return str.map {
        val sumCode = it.code + nums
        if (sumCode <= 122) {
            Char(sumCode)
        } else {
            Char(96 + (sumCode % 122))
        }
    }.joinToString (separator = "")
}
