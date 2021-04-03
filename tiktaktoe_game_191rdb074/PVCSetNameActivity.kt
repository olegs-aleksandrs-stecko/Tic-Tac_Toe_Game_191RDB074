package com.example.tiktaktoe_game_191rdb074

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class PVCSetNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pvc_set_name)
    }

    fun PlayPVC(view: View) {
        val Player1Name = findViewById<EditText>(R.id.Player1Name)

        val intent =  Intent(this, GameActivity::class.java)
        intent.putExtra("Player1Name",Player1Name.text.toString())
        intent.putExtra("Player2Name","Computer")
        intent.putExtra("PVC",true)
        startActivity(intent)

    }

}