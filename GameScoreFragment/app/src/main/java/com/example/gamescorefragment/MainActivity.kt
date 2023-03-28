package com.example.gamescorefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        fragmentManager
            .beginTransaction()
            .add(R.id.fragment_frame_layout, TeamScoreFragment
                .newInstance("A", "0"))
            .add(R.id.fragment_frame_layout, TeamScoreFragment
                .newInstance("B", "0"))
            .commit()
    }
}