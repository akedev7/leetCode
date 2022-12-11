package com.company.medium.phoneNumberMnemonics

fun main() {
    getPhoneNumberMnemonics("1905").forEach { println(it) }
    println("--------")
    getPhoneNumberMnemonicsV2("1905").forEach { println(it) }
}

private val PHONE_MAP: Map<Char, List<Char>> = mapOf(
        '1' to listOf('1'),
        '2' to listOf('a', 'b', 'c'),
        '3' to listOf('d', 'e', 'f'),
        '4' to listOf('g', 'h', 'i'),
        '5' to listOf('j', 'k', 'l'),
        '6' to listOf('m', 'n', 'o'),
        '7' to listOf('p', 'q', 'r', 's'),
        '8' to listOf('t', 'u', 'v'),
        '9' to listOf('w', 'x', 'y', 'z'),
        '0' to listOf('0'),
)

fun getPhoneNumberMnemonics(str: String): List<String> {
    var currentList = listOf<List<Char>>(listOf())
    str.forEach { element ->
        val newList = mutableListOf<List<Char>>()
        PHONE_MAP[element]?.forEach { char ->
            currentList.forEach {
                val subset = it.toMutableList()
                subset.add(char)
                newList.add(subset)
            }
        }
        currentList = newList
    }
    return currentList.map {
        it.joinToString(separator = "")
    }.toList()
}


fun getPhoneNumberMnemonicsV2(phoneNumber: String): List<String> {
    val resultList: MutableList<String> = mutableListOf()
    var currentString = CharArray(phoneNumber.length)
    getPhoneNumberMnemonicsHelper(0, phoneNumber, currentString, resultList)
    return resultList
}

fun getPhoneNumberMnemonicsHelper(index: Int, phoneNumber: String, currentString: CharArray, resultList: MutableList<String>) {
    if (index == phoneNumber.length) {
        val mnemonic = currentString.joinToString(separator = "")
        resultList.add(mnemonic)
    } else {
        val digit = phoneNumber[index]
        val letters = PHONE_MAP[digit]
        letters?.forEach {
            currentString[index] = it
            getPhoneNumberMnemonicsHelper(index + 1, phoneNumber, currentString, resultList)
        }
    }
}



