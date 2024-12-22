package com.example.kotlinproject

import org.springframework.stereotype.Service

@Service
class PairSumService {

    fun findAllPairsWithSum(arr: IntArray, targetSum: Int) {
        val usedPairs = mutableSetOf<Pair<Int, Int>>()

        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                if (arr[i] + arr[j] == targetSum) {
                    val pair = Pair(arr[i], arr[j])

                    if (!usedPairs.contains(pair) && !usedPairs.contains(Pair(arr[j], arr[i]))) {
                        println("Pair found: ${arr[i]} and ${arr[j]}")
                        usedPairs.add(pair)
                        break
                    }
                }
            }
        }
        if (usedPairs.isEmpty()) {
            println("No pair found with sum $targetSum")
        }
    }
}
