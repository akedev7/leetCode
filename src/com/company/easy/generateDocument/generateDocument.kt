package com.company.easy.generateDocument

fun main() {
    println(getGenerateDocument("Bste!hetsi ogEAxpelrt x ", "AlgoExpert is the Best!"))
}

fun getGenerateDocument(characters: String, document: String): Boolean {
    val map = mutableMapOf<Char, Int>()

    characters.forEach {
        map[it] = map[it]?.plus(1) ?: 1
    }

    document.forEach {
        if (map[it] == null || map[it] == 0) return false
        map[it] = map[it]!! - 1
    }
    return true
}
