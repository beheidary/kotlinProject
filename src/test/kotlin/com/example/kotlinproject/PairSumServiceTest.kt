package com.example.kotlinproject

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@ContextConfiguration(classes = [PairSumService::class, TestConfig::class])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PairSumServiceTest {

    @Autowired
    lateinit var pairSumService: PairSumService

    private fun captureOutput(block: () -> Unit): String {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        block()
        return outputStream.toString().trim()
    }

    @Test
    fun testPairFound() {
        val arr = intArrayOf(10, 15, 3, 7)
        val targetSum = 17
        val output = captureOutput { pairSumService.findAllPairsWithSum(arr, targetSum) }
        assertTrue(output.contains("Pair found: 10 and 7"))
    }

    @Test
    fun testNoPairFound() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        val targetSum = 10
        val output = captureOutput { pairSumService.findAllPairsWithSum(arr, targetSum) }
        assertEquals("No pair found with sum 10", output)
    }

    @Test
    fun testAllZeros() {
        val arr = intArrayOf(0, 0, 0, 0, 0, 0)
        val targetSum = 0
        val output = captureOutput { pairSumService.findAllPairsWithSum(arr, targetSum) }
        assertTrue(output.contains("Pair found: 0 and 0"))
    }

    @Test
    fun testMixedNumbers() {
        val arr = intArrayOf(0, 2, 3, -4, -6, 8)
        val targetSum = 4
        val output = captureOutput { pairSumService.findAllPairsWithSum(arr, targetSum) }
        assertTrue(output.contains("Pair found: -4 and 8"))
    }

    @Test
    fun testMultiplePairs() {
        val arr = intArrayOf(4, 6, 11, -1, 8, 2, 56, 26, 36)
        val targetSum = 10
        val output = captureOutput { pairSumService.findAllPairsWithSum(arr, targetSum) }
        assertTrue(output.contains("Pair found: 4 and 6"))
        assertTrue(output.contains("Pair found: 11 and -1"))
        assertTrue(output.contains("Pair found: 8 and 2"))
    }

    @Test
    fun testDuplicatePairs() {
        val arr = intArrayOf(1, 1, 1, 1)
        val targetSum = 2
        val output = captureOutput { pairSumService.findAllPairsWithSum(arr, targetSum) }
        assertTrue(output.contains("Pair found: 1 and 1"))
        assertEquals(1, output.lines().count { it.contains("Pair found") })
    }
    @Test
    fun testInvalidInputWithDecimal() {
        val input = "15 15.26 59 62"
        val output = captureOutput {
            try {
                val parts = input.split(" ").filter { it.isNotBlank() }
                val arr = parts.dropLast(1).map { it.toInt() }.toIntArray()
                val targetSum = parts.last().toInt()
                pairSumService.findAllPairsWithSum(arr, targetSum)
            } catch (e: NumberFormatException) {
                println("Invalid input.")
            }
        }
        assertEquals("Invalid input.", output)
    }

    @Test
    fun testInvalidInputWithNonNumeric() {
        val input = "45 23 99 3 dsd 25"
        val output = captureOutput {
            try {
                val parts = input.split(" ").filter { it.isNotBlank() }
                val arr = parts.dropLast(1).map { it.toInt() }.toIntArray()
                val targetSum = parts.last().toInt()
                pairSumService.findAllPairsWithSum(arr, targetSum)
            } catch (e: NumberFormatException) {
                println("Invalid input.")
            }
        }
        assertEquals("Invalid input.", output)
    }
}
