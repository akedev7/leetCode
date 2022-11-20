package com.company.palindromeCheck

fun main() {
    println(checkPalindromeV1("abcdcba"))
    println(checkPalindromeV2("abcdcba"))
    println(checkPalindromeV3("abcdcba"))
    println(checkPalindromeV4("abcdcba"))
}


// Space complexity = O(n)
//Time complexity = O(n^2) - because when a string use the operator += it basically iterates the string and add into the end of the string
fun checkPalindromeV1(inputString: String): Boolean {
    var outputString = ""
    for (i in inputString.count() - 1 downTo 0) {
        outputString += inputString[i]
    }

    if (outputString == inputString) {
        return true
    }
    return false
}

//Space complexity = O(n)
//Time complexity = O(n/2) then O(n)
fun checkPalindromeV2(inputString: String): Boolean {
    var outputList: MutableList<Char> = mutableListOf()
    for (i in inputString.count() - 1 downTo 0) {
        outputList.add(inputString[i])
    }

    if (outputList.joinToString(separator = "") { it.toString() } == inputString) {
        return true
    }
    return false
}


//Space complexity = O(n) due to call stack takes memory space. (Sometimes, complier is smart and make it tail recursive i.e., no replace call in same stack call, so it becomes O(1)
//Time complexity = O(n/2) then O(n)
fun checkPalindromeV3(inputString: String): Boolean {
    if (inputString.count() < 2) {
        return true
    }
    return inputString.last() == inputString.first() && checkPalindromeV3(inputString.slice(IntRange(1, inputString.count() - 2)))
}

//Space complexity: O(1)
//Time complexity O(N)
fun checkPalindromeV4(inputString: String): Boolean {
    var startPointer = 0
    var endPointer = inputString.count() - 1

    while (startPointer < endPointer) {
        if (inputString[startPointer++] != inputString[endPointer--]) {
            return false
        }
    }
    return true
}
