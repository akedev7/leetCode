package com.company.easy.findThreeLargestNumber

fun main() {
   getThreeLargestNumber(listOf(141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7)).forEach {
       println(it)
   }
}

fun getThreeLargestNumber(list: List<Int>): Array<Int?> {
    val intArray = arrayOfNulls<Int>(3)

    list.forEach { item ->
        intArray.reversed().forEachIndexed { index: Int, i: Int? ->
            val pointer = intArray.size - 1 - index
            if (i == null) {
                intArray[pointer] = item
                return@forEach
            } else if (item > i) {
                var j = 0
                while ( j < pointer) {
                    intArray[j] = intArray[++j]
                }
                intArray[pointer] = item
                return@forEach
            }
        }
    }
    return intArray
}
