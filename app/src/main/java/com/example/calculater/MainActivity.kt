package com.example.calculater

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculater.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.sin

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var isNewOper: Boolean = true
    var pi = "3.14159265"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Number listeners
        // btn00.setOnClickListener { appendOnClick(true, "00") }
        binding.zeroNum.setOnClickListener { appendOnClick(true, "0") }
        binding.oneNum.setOnClickListener { appendOnClick(true, "1") }
        binding.twoNum.setOnClickListener { appendOnClick(true, "2") }
        binding.threeNum.setOnClickListener { appendOnClick(true, "3") }
        binding.fourNum.setOnClickListener { appendOnClick(true, "4") }
        binding.fiveNum.setOnClickListener { appendOnClick(true, "5") }
        binding.sixNum.setOnClickListener { appendOnClick(true, "6") }
        binding.sevenNum.setOnClickListener { appendOnClick(true, "7") }
        binding.eightNum.setOnClickListener { appendOnClick(true, "8") }
        binding.nineNum.setOnClickListener { appendOnClick(true, "9") }
        binding.dot.setOnClickListener { appendOnClick(true, ".") }


        //Operator Listeners
        binding.plusOperator.setOnClickListener { appendOnClick(false, "+") }
        binding.minusOperator.setOnClickListener { appendOnClick(false, "-") }
        binding.multiplicationOperator.setOnClickListener { appendOnClick(false, "*") }
        binding.divideOperator.setOnClickListener { appendOnClick(false, "/") }
        binding.openParenthesses.setOnClickListener { appendOnClick(false, "(") }
        binding.closeParenthesses.setOnClickListener { appendOnClick(false, ")") }
        binding.moduloOperator.setOnClickListener { appendOnClick(false, "%") }
        binding.piOperator.setOnClickListener { appendOnClick(false, "π") }
        binding.moduloOperator.setOnClickListener { appendOnClick(false, "%") }
        binding.divTowOperator.setOnClickListener { appendOnClick(false, "1/") }
        binding.factOperator.setOnClickListener { appendOnClick(false, "!") }
        binding.rootOperator.setOnClickListener { appendOnClick(false, "√") }
        binding.xPowerTwo.setOnClickListener { appendOnClick(false, "^2") }
        binding.powOperator.setOnClickListener { appendOnClick(false, "^") }
        binding.sinOperator.setOnClickListener {
            if (binding.sinOperator.text.equals("sin"))
                appendOnClick(false, "sin")
            else {
              //  appendOnClick(false,"${sin(Math.toRadians())}sin")
            }
        }
        binding.cosOperator.setOnClickListener { appendOnClick(false, "cos") }
        binding.tanOperator.setOnClickListener { appendOnClick(false, "tan") }
        binding.lgOperator.setOnClickListener { appendOnClick(false, "log") }
        binding.lnOperator.setOnClickListener { appendOnClick(false, "ln") }
        binding.eOperator.setOnClickListener { appendOnClick(false, "e") }


        binding.back.setOnClickListener {
            val string = binding.tvInput.text.toString()
            if (string.isNotEmpty()) {
                binding.tvInput.text = string.substring(0, string.length - 1)
            }
            binding.tvOutput.text = ""
        }
        binding.clear.setOnClickListener {
            clear()
        }

        binding.equalOperation.setOnClickListener {
            calculate()
        }


    }

    //now create methods

    private fun appendOnClick(clear: Boolean, string: String) {

        if (clear) {
            binding.tvOutput.text = ""
            binding.tvInput.append(string)
        } else {
            binding.tvInput.append(binding.tvOutput.text)
            binding.tvInput.append(string)
            binding.tvOutput.text = ""
        }
    }

    private fun clear() {
        binding.tvInput.text = ""
        binding.tvOutput.text = ""

    }

    private fun calculate() {

        try {

            val input = ExpressionBuilder(binding.tvInput.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()
            if (output == longOutput.toDouble()) {
                binding.tvOutput.text = longOutput.toString()
            } else {
                binding.tvOutput.text = output.toString()
            }

        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }
}


