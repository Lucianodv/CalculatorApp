package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat


import kotlin.math.exp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //boton limpiar
        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        //boton (
        button_parentesis_izq.setOnClickListener {
            input.text = addToInputText("(")
        }

        // boton )
        button_parentesis_der.setOnClickListener {
            input.text = addToInputText(")")
        }

        //boton 0
        button_0.setOnClickListener {
            input.text = addToInputText("0")
        }

        //boton 1
        button_1.setOnClickListener {
            input.text = addToInputText("1")
        }

        //boton 2
        button_2.setOnClickListener {
            input.text = addToInputText("2")
        }

        //boton 3
        button_3.setOnClickListener {
            input.text = addToInputText("3")
        }

        //boton 4
        button_4.setOnClickListener {
            input.text = addToInputText("4")
        }

        //boton 5
        button_5.setOnClickListener {
            input.text = addToInputText("5")
        }

        //boton 6
        button_6.setOnClickListener {
            input.text = addToInputText("6")
        }

        //boton 7
        button_7.setOnClickListener {
            input.text = addToInputText("7")
        }

        //boton 8
        button_8.setOnClickListener {
            input.text = addToInputText("8")
        }

        //boton 9
        button_9.setOnClickListener {
            input.text = addToInputText("9")
        }

        //boton .
        button_dot.setOnClickListener {
            input.text = addToInputText(".")
        }

        //boton division
        button_division.setOnClickListener {
            input.text = addToInputText("÷")
        }

        //boton multiplicacion
        button_x.setOnClickListener {
            input.text = addToInputText("×")
        }

        //boton suma
        button_suma.setOnClickListener {
            input.text = addToInputText("+")
        }

        //boton resta
        button_resta.setOnClickListener {
            input.text = addToInputText("-")
        }

        //boton igual
        button_igual.setOnClickListener {
           showResult()
        }

    }
    private  fun addToInputText(buttonValue: String):String{
            return "${input.text}$buttonValue"
        }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"),"/")
        expression = input.text.replace(Regex("×"),"*")
        return expression
    }

    private fun showResult(){
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()

            if (result.isNaN()){
                //show error
                output.text = "ERROR"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // show result
                  output.text = DecimalFormat("0.######").format(result).toString()
                  output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception){
           //show Error Message
            output.text = "ERROR"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }


}
