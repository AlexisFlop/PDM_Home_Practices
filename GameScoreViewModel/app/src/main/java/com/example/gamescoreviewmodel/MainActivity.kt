package com.example.gamescoreviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    private lateinit var teamAScoreTextView: TextView
    private lateinit var teamBScoreTextView: TextView
    private lateinit var addOnePointTeamABtn: Button
    private lateinit var addOnePointTeamBBtn: Button
    private lateinit var gameOverBtn: Button
    private val teamAViewModel : TeamAViewModel by viewModels()
    private val teamBViewModel : TeamBViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListeners()
        updateScore('A')
        updateScore('B')
    }

    private fun bind(){
        teamAScoreTextView = findViewById(R.id.team_a_score_text_view)
        teamBScoreTextView = findViewById(R.id.team_b_score_text_view)
        addOnePointTeamABtn = findViewById(R.id.add_one_point_a_action)
        addOnePointTeamBBtn = findViewById(R.id.add_one_point_b_action)
        gameOverBtn = findViewById(R.id.game_over_action)
    }

    private fun addListeners(){
        addOnePointTeamABtn.setOnClickListener(){
            teamAViewModel.increaseScore()
            updateScore('A')
        }
        addOnePointTeamBBtn.setOnClickListener(){
            teamBViewModel.increaseScore()
            updateScore('B')
        }

    }

    private fun updateScore(teamName : Char){
        when(teamName){
            'A'-> teamAScoreTextView.text = teamAViewModel.getScore().toString()
            'B'-> teamBScoreTextView.text = teamBViewModel.getScore().toString()

        }
    }
}