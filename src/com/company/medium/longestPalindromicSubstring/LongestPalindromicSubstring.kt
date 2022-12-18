package com.company.medium.longestPalindromicSubstring

fun main() {
    println(getLongestPalindromicSubstring("abaxyzzyxf"))
}

fun getLongestPalindromicSubstring(inputString: String): String {
    var longestPalindrome = ""
    for (i in inputString.indices) {

        // Get central palindrome e.g. cabac
        val centralPalindrome: String = getPalindrome(inputString, i - 1, i + 1, inputString[i].toString())

        // Get non-central palindrome e.g, caac
        val nonCentralPalindrome = getPalindrome(inputString, i - 1, i, "")

        //Check if it's longer than the current longest one
        if (centralPalindrome.length > longestPalindrome.length) {
            longestPalindrome = centralPalindrome
        }

        if (nonCentralPalindrome.length > longestPalindrome.length) {
            longestPalindrome = nonCentralPalindrome
        }
    }
    return longestPalindrome
}

private fun getPalindrome(inputString: String, leftPointer: Int, rightPointer: Int, currentPalindrome: String): String {
    var currentPalindrome = currentPalindrome
    var leftPointer = leftPointer
    var rightPointer = rightPointer

    while (leftPointer >= 0 && rightPointer < inputString.length && inputString[leftPointer] == inputString[rightPointer]) {
        currentPalindrome = inputString[leftPointer] + currentPalindrome + inputString[rightPointer]
        leftPointer--
        rightPointer++
    }
    return currentPalindrome
}
