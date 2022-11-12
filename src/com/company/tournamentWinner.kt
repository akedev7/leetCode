package com.company

fun main() {
    val result = tournamentWinner(arrayListOf(Pair("HTML", "C#"), Pair("C#", "Python"), Pair("Python", "HTML")), intArrayOf(0, 0 ,1))
    println(result)
}

fun tournamentWinner(listOfCompetition: ArrayList<Pair<String, String>>, matchResult: IntArray): Pair<String, Int> {
    val scoreBoard = mutableMapOf<String, Int>()
    var matchNumber = 0
    var currentBestTeam = "InitTeam" to 0
    listOfCompetition.forEach{

        if (matchResult[matchNumber++] == 1) {
            scoreBoard[it.first] = scoreBoard[it.first]?.plus(1) ?: 1

            if (scoreBoard[it.first]!! > currentBestTeam.second) {
                currentBestTeam = it.first to scoreBoard[it.first]!!
            }
        } else {
            scoreBoard[it.second] = scoreBoard[it.second]?.plus(1) ?: 1
            if (scoreBoard[it.second]!! > currentBestTeam.second) {
                currentBestTeam = it.second to scoreBoard[it.second]!!
            }
        }
    }
    return currentBestTeam
}
