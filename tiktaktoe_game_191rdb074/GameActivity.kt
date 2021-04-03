package com.example.tiktaktoe_game_191rdb074

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class GameActivity : AppCompatActivity() {



    private var player1Score = 0
    private var player2Score = 0
    private var firstPlayerMove: Boolean = true
    private var draw : Boolean = true
    private var player1Won : Boolean = false
    private var player2Won : Boolean = false
    private var squares =  arrayOf<ArrayList<Button>>(arrayListOf(), arrayListOf(), arrayListOf())
    private var Player1Name : String = ""
    private var Player2Name : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        Player1Name = intent.getStringExtra("Player1Name").toString()
        Player2Name = intent.getStringExtra("Player2Name").toString()
        val PVC : Boolean = intent.getBooleanExtra("PVC", false )


        val NamePlayer1 = findViewById<TextView>(R.id.NamePlayer1)
        val NamePlayer2 = findViewById<TextView>(R.id.NamePlayer2)

        NamePlayer1.text = Player1Name
        NamePlayer2.text = Player2Name

        for (i in 0..2) {
            for (j in 0..2) {
                val buttonId = "Square$i$j"
                val resId = resources.getIdentifier(buttonId, "id", packageName) 

                squares[i].add(findViewById(resId))

                squares[i][j].setOnClickListener {
                    buttonPressed(squares[i][j], PVC)

                }
            }

        }
    }


    private fun buttonPressed(square: Button, PVC: Boolean,) {
        if (square.text == "-") {
            if (firstPlayerMove) {
                firstPlayerMove = false
                square.text = "X"
            } else {
                firstPlayerMove = true
                square.text = "O"
            }
            checkGame(PVC)
        }
    }


    private fun checkGame(PVC: Boolean) {

        if(squares[0][0].text == squares[1][1].text && squares[1][1].text == squares[2][2].text)
            XorO(squares[0][0].text as String)

        else if(squares[0][2].text == squares[1][1].text && squares[1][1].text == squares[2][0].text)
            XorO(squares[0][2].text as String)

        else {
            for (i in 0..2) {
                if (player1Won || player2Won)
                    break
                if (squares[i][0].text == squares[i][1].text && squares[i][1].text == squares[i][2].text)
                    XorO(squares[i][0].text as String)
            }

            for (i in 0..2) {
                if (player1Won || player2Won)
                    break
                if (squares[0][i].text == squares[1][i].text && squares[1][i].text == squares[2][i].text)
                    XorO(squares[0][i].text as String)
            }

        }

        if(player1Won){
            Toast.makeText(this@GameActivity, "$Player1Name won.", Toast.LENGTH_SHORT).show()
            player1Score++
            endGame()
            val textView1 = findViewById<TextView>(R.id.ScorePlayer1)
            textView1.text = "$player1Score"
            player1Won = false
            return
        }

        if(player2Won){
            Toast.makeText(this@GameActivity, "$Player2Name won.", Toast.LENGTH_SHORT).show()
            player2Score++
            endGame()
            val textView2 = findViewById<TextView>(R.id.ScorePlayer2)
            textView2.text = "$player2Score"
            player2Won = false
            return
        }

        for(i in 0..2){
            for(j in 0..2){
                if (squares[i][j].text == "-"){
                    draw = false
                    break
                }
            }
        }

        if (draw){
            Toast.makeText(this@GameActivity, "Draw.", Toast.LENGTH_SHORT).show()
            endGame()
            return
        } else
            draw = true

        if (PVC)
            AI()

    }

    private fun XorO(square: String){
        when(square){
            "X" -> player1Won = true
            "O" -> player2Won = true
        }
    }

    private fun AI(){
        var i = 0
        var j = 0
        while(true){
            i = (0..2).random()
            j = (0..2).random()
            if (squares[i][j].text == "-")
                break
        }

        buttonPressed(squares[i][j], false)
    }

    private fun endGame() {
        if (!firstPlayerMove)
            firstPlayerMove = true
        for (i in 0..2) {
            for (j in 0..2) {
                squares[i][j].text = "-"
            }
        }
    }
}

