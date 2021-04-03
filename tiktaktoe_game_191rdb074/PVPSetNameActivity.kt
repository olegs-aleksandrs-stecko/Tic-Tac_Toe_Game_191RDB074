package com.example.tiktaktoe_game_191rdb074

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView



class PVPSetNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pvp_set_name)
    }

    fun PlayPVP(view: View) {
        val Player1Name = findViewById<EditText>(R.id.Player1Name)
        val Player2Name = findViewById<EditText>(R.id.Player2Name)

       val intent =  Intent(this, GameActivity::class.java)
        intent.putExtra("Player1Name",Player1Name.text.toString())
        intent.putExtra("Player2Name",Player2Name.text.toString())
        intent.putExtra("PVC",false)
        startActivity(intent)

}


}