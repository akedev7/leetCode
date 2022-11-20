package com.company.firstNonRepeatCharacter

fun main() {
    println(getFirstNonRepeatingCharacter("abcdcaf"))
}

fun getFirstNonRepeatingCharacter(inputString: String): Char? {
    val map = mutableMapOf<Char, Int>()
    inputString.forEach {
        map[it] = map[it]?.plus(1) ?: 1
    }

    map.forEach {
        if (it.value == 1) {
            return it.key
        }
    }
    return null
}


