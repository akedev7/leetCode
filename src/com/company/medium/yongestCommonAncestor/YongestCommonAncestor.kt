package com.company.medium.yongestCommonAncestor


data class Person(val name: String, val ancestor: Person? = null)
fun main() {
    val topAncestor = Person("A")
    val firstPerson = Person("T", Person("P", Person("H", Person("B", topAncestor))))
    val secondPerson = Person("I", Person("B", topAncestor))
    println(getYoungestCommonAncestor(topAncestor, firstPerson, secondPerson).name)
}

fun getYoungestCommonAncestor(topAncestor: Person, firstPerson: Person, secondPerson: Person): Person {
    val firstPersonDepth = getDepth(firstPerson, topAncestor)
    val secondPersonDepth = getDepth(firstPerson, topAncestor)
    return if (firstPersonDepth > secondPersonDepth) {
        getYoungestAncestor(secondPerson, firstPerson, firstPersonDepth - secondPersonDepth)
    } else {
        getYoungestAncestor(firstPerson, secondPerson, secondPersonDepth - firstPersonDepth)
    }
}

fun getYoungestAncestor(lowerPerson: Person, higherPerson: Person, diff: Int): Person {
    var low = lowerPerson
    var high = higherPerson
    repeat(diff) {
        low = low.ancestor!!
    }
    while (low.ancestor != higherPerson.ancestor) {
        low = low.ancestor!!
        high = high.ancestor!!
    }
    return low.ancestor!!
}

fun getDepth(person: Person, topAncestor: Person): Int {
    var depth = 0
    var p = person
    while (p.name != topAncestor.name) {
        p = p.ancestor!!
        depth++
    }
    return depth
}
