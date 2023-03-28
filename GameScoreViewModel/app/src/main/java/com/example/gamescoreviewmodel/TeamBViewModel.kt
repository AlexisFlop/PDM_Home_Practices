package com.example.gamescoreviewmodel

import androidx.lifecycle.ViewModel

class TeamBViewModel: ViewModel() {
    private var score: Int = 0

    fun increaseScore(){
        score++
    }
    fun getScore() = score
}