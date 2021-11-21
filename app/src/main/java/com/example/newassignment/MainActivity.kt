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
    private var player = 1
    private var p1 = ArrayList<Int>()
    private var p2 = ArrayList<Int>()
    private var clicks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

        private fun init() {
            button1 = findViewById<Button>(R.id.button1)
            button2 = findViewById<Button>(R.id.button2)
            button3 = findViewById<Button>(R.id.button3)
            button4 = findViewById<Button>(R.id.button4)
            button5 = findViewById<Button>(R.id.button5)
            button6 = findViewById<Button>(R.id.button6)
            button7 = findViewById<Button>(R.id.button7)
            button8 = findViewById<Button>(R.id.button8)
            button9 = findViewById<Button>(R.id.button9)

            button1.setOnClickListener(this)
            button2.setOnClickListener(this)
            button3.setOnClickListener(this)
            button4.setOnClickListener(this)
            button5.setOnClickListener(this)
            button6.setOnClickListener(this)
            button7.setOnClickListener(this)
            button8.setOnClickListener(this)
            button9.setOnClickListener(this)
        }


    override fun onClick(clickedView: View?) {
        if(clickedView is Button ){
            var bNum = 0
            when (clickedView.id){
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
            if (bNum != 0)
            {
                game(clickedView, bNum)
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

        //gamocxadeba
        if (win == 1) {
            Toast.makeText(this, "player X won", Toast.LENGTH_SHORT).show()
            finish()
        }
        else if (win == 2){
            Toast.makeText(this, "player O won", Toast.LENGTH_SHORT).show()
            finish()
        }
        else if (clicks == 9){
            Toast.makeText(this, "draw", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}