package com.amlitest.coolbutton

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var xsTurn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_button.setOnClickListener {
            startOver()
        }
    }

    fun markButton(view: View) {
        if (view !is Button) {
            return
        }
        val button = view as Button
        if (button.text.isEmpty()) {
            button.text = if (xsTurn) "X" else "Y"
            button.setTextColor(if (xsTurn) Color.RED else Color.BLUE)
            xsTurn = !xsTurn
            checkForWinner()
        }
    }

    private fun TableLayout.getButtons(): List<Button> {
        val buttons = arrayListOf<Button>()
        for (i in 0 until childCount) {
            val row = getChildAt(i) as TableRow
            for (j in 0 until row.childCount) {
                buttons.add(row.getChildAt(j) as Button)
            }
        }
        return buttons
    }

    private fun startOver() {
        val buttons: List<Button> = ttt_table.getButtons()
        for (button in buttons) {
            button.text = ""
        }
    }

    private fun checkForWinner() {
        // TODO
    }

    private fun aiTurn() {
        // TODO
    }
}
