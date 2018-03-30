package com.pjx.skad.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateTextView("0")
    }

    private val listOfOperations: MutableList<String> = arrayListOf()
    private val cacheOfNumbers: MutableList<String> = arrayListOf()

    private fun mkString(list: List<String>, joiner: String = "") : String {
        if (list.isEmpty()) return ""
        return list.reduce {r, s -> r + joiner + s}
    }

    private fun clearData() {
        listOfOperations.clear()
        cacheOfNumbers.clear()
    }

    private fun updateTextView(textViewString: String) {
        val calcString = mkString(listOfOperations, " ")
        val calcTextView = findViewById<TextView>(R.id.calcText)
        calcTextView.text = calcString

        val displayTextView = findViewById<TextView>(R.id.calcText)
        displayTextView.text = textViewString
    }

    fun acClick(view: View) {
        clearData()
        updateTextView("0")
    }

    fun eqlsClick(view: View) {
        listOfOperations.add(mkString(cacheOfNumbers))
        cacheOfNumbers.clear()

        val calculation = MagicCalculator()
        val result = calculation.calculate(listOfOperations)

        updateTextView(result.toString())
        clearData()
    }

    fun operationClick(view: View) {
        val operations = view as TextView

        if(cacheOfNumbers.isEmpty()) return

        listOfOperations.add(mkString(cacheOfNumbers))
        cacheOfNumbers.clear()
        listOfOperations.add(operations.text.toString())

        updateTextView(operations.text.toString())
    }

    fun numberClick(view: View) {
        val numbers = view as TextView
        val numberString = numbers.text

        cacheOfNumbers.add(numberString.toString())
        val text = mkString(cacheOfNumbers)
        updateTextView(text)
    }
}
