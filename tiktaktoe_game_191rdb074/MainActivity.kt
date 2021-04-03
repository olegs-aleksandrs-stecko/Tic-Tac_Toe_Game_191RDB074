package com.example.tiktaktoe_game_191rdb074

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this@MainActivity, "Game welcomes you:)", Toast.LENGTH_SHORT).show()
    }

    fun showCredits(view: View) {
        Intent(this, CreditsActivity::class.java).also{
            startActivity(it)
        }
    }

    fun showPVC(view: View) {
        Intent(this, PVCSetNameActivity::class.java).also{
            startActivity(it)
        }
    }

    fun showPVP(view: View) {
        Intent(this, PVPSetNameActivity::class.java).also{
            startActivity(it)
        }
    }

}