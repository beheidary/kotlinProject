package com.example.kotlinproject

import org.springframework.stereotype.Component
import java.util.Scanner

@Component
class InputHandler(private val pairSumService: PairSumService) {

    fun processInput(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("Enter an array of integers separated by spaces, followed by the target sum:")
            val input = scanner.nextLine().trim()

            if (input.equals("exit", ignoreCase = true)) {
                println("Exiting")
                break
            }

            try {
                val parts = input.split(" ").filter { it.isNotBlank() }

                if (parts.size < 2) {
                    println("Invalid input.")
                    continue
                }

                val arr = parts.dropLast(1).map { it.toInt() }.toIntArray()
                val targetSum = parts.last().toInt()

                println("Input Array: ${arr.joinToString(", ")}")
                println("Target Sum: $targetSum")

                pairSumService.findAllPairsWithSum(arr, targetSum)

            } catch (e: NumberFormatException) {
                println("Invalid input.")
            } catch (e: Exception) {
                println("An error occurred: ${e.message}")
            }
        }
    }
}
