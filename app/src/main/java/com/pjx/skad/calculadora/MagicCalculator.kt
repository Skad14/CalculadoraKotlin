package com.pjx.skad.calculadora

class MagicCalculator {

    fun calculate(calcList: List<String>): Int {
        var operation = " "
        var number = 0

        calcList.forEach { op ->
            when {
                op == "+" || op == "÷" || op == "x" || op == "-"  -> operation = op

                operation == "-" -> number -= op.toInt()
                operation == "÷" -> number /= op.toInt()
                operation == "x" -> number *= op.toInt()
                else -> number += op.toInt()
            }
        }
        return number
    }
}