package com.example.newassignment

import android.graphics.Color
import android.view.View
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1:Button
    private lateinit var button2:Button
    private lateinit var button3:Button
    private lateinit var button4:Button
    private lateinit var button5:Button
    private lateinit var button6:Button
    private lateinit var button7:Button
    private lateinit var button8:Button
    private lateinit var button9:Button
    private lateinit var text: TextView
    private var player = 1
    private var p1 = ArrayList<Int>()
    private var p2 = ArrayList<Int>()
    private var clicks = 0
    private lateinit var start:Button
    private var start_b = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

        private fun init() {
            text = findViewById<TextView>(R.id.text)
            button1 = findViewById<Button>(R.id.button1)
            button2 = findViewById<Button>(R.id.button2)
            button3 = findViewById<Button>(R.id.button3)
            button4 = findViewById<Button>(R.id.button4)
            button5 = findViewById<Button>(R.id.button5)
            button6 = findViewById<Button>(R.id.button6)
            button7 = findViewById<Button>(R.id.button7)
            button8 = findViewById<Button>(R.id.button8)
            button9 = findViewById<Button>(R.id.button9)
            start = findViewById<Button>(R.id.start)

            button1.setOnClickListener(this)
            button2.setOnClickListener(this)
            button3.setOnClickListener(this)
            button4.setOnClickListener(this)
            button5.setOnClickListener(this)
            button6.setOnClickListener(this)
            button7.setOnClickListener(this)
            button8.setOnClickListener(this)
            button9.setOnClickListener(this)
            start.setOnClickListener(this)
        }


    override fun onClick(clickedView: View?) {
            if (clickedView is Button) {
                when (clickedView.id) {
                    R.id.start -> start_b = 1
                }
                if (start_b == 1) {
                    button1.setBackgroundColor(Color.WHITE)
                    button2.setBackgroundColor(Color.WHITE)
                    button3.setBackgroundColor(Color.WHITE)
                    button4.setBackgroundColor(Color.WHITE)
                    button5.setBackgroundColor(Color.WHITE)
                    button6.setBackgroundColor(Color.WHITE)
                    button7.setBackgroundColor(Color.WHITE)
                    button8.setBackgroundColor(Color.WHITE)
                    button9.setBackgroundColor(Color.WHITE)

                    var bNum = 0
                    when (clickedView.id) {
                        R.id.button1 -> bNum = 1
                        R.id.button2 -> bNum = 2
                        R.id.button3 -> bNum = 3
                        R.id.button4 -> bNum = 4
                        R.id.button5 -> bNum = 5
                        R.id.button6 -> bNum = 6
                        R.id.button7 -> bNum = 7
                        R.id.button8 -> bNum = 8
                        R.id.button9 -> bNum = 9

                    }
                    if (bNum != 0) {
                        game(clickedView, bNum)
                    }
                }
            }

    }

    private fun game(clickedView: Button, bNum: Int) {
        if(player == 1){
            clickedView.text = "X"
            clickedView.setTextColor(Color.RED)
            player = 2
            p1.add(bNum)
            clicks += 1
        }
        else{
            clickedView.text = "O"
            p2.add(bNum)
            clickedView.setTextColor(Color.BLUE)
            player = 1
            p2.add(bNum)
            clicks += 1
        }
        clickedView.isEnabled = false
        check()
    }
    private fun check(){
        var win = 0

        //player 1 wins
        if(p1.contains(1) && p1.contains(2) && p1.contains(3)){
            win = 1
        }
        if(p1.contains(4) && p1.contains(5) && p1.contains(6)){
            win = 1
        }
        if(p1.contains(7) && p1.contains(8) && p1.contains(9)){
            win = 1
        }
        if(p1.contains(1) && p1.contains(4) && p1.contains(7)){
            win = 1
        }
        if(p1.contains(2) && p1.contains(5) && p1.contains(8)){
            win = 1
        }
        if(p1.contains(3) && p1.contains(6) && p1.contains(9)){
            win = 1
        }
        if(p1.contains(1) && p1.contains(5) && p1.contains(9)){
            win = 1
        }
        if(p1.contains(3) && p1.contains(7) && p1.contains(5)){
            win = 1
        }


        //player 2 wins
        if(p2.contains(1) && p2.contains(2) && p2.contains(3)){
            win = 2
        }
        if(p2.contains(4) && p2.contains(5) && p2.contains(6)){
            win = 2
        }
        if(p2.contains(7) && p2.contains(8) && p2.contains(9)){
            win = 2
        }
        if(p2.contains(1) && p2.contains(4) && p2.contains(7)){
            win = 2
        }
        if(p2.contains(2) && p2.contains(5) && p2.contains(8)){
            win = 2
        }
        if(p2.contains(3) && p2.contains(6) && p2.contains(9)){
            win = 2
        }
        if(p2.contains(1) && p2.contains(5) && p2.contains(9)){
            win = 2
        }
        if(p2.contains(3) && p2.contains(7) && p2.contains(5)){
            win = 2
        }

        fun restart(){
            p1.clear()
            p2.clear()
            win = 0
            player = 1
            clicks = 0
            start_b = 0

            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""

            button1.setBackgroundColor(Color.BLACK)
            button2.setBackgroundColor(Color.BLACK)
            button3.setBackgroundColor(Color.BLACK)
            button4.setBackgroundColor(Color.BLACK)
            button5.setBackgroundColor(Color.BLACK)
            button6.setBackgroundColor(Color.BLACK)
            button7.setBackgroundColor(Color.BLACK)
            button8.setBackgroundColor(Color.BLACK)
            button9.setBackgroundColor(Color.BLACK)

            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true

        }

        //gamocxadeba
        if (win == 1) {
            text.text = "player X won"
            restart()
        }
        else if (win == 2){
            text.text = "player O won"
            restart()
        }
        else if (clicks == 9){
            text.text = "Draw"
            restart()
        }

    }

}