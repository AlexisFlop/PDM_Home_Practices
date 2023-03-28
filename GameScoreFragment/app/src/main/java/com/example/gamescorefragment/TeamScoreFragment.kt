package com.example.gamescorefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_NAME = "Error_Name"
private const val ARG_SCORE = "Error_Score"

/**
 * A simple [Fragment] subclass.
 * Use the [TeamScoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TeamScoreFragment : Fragment() {
    private var teamName: String? = null
    private var teamScore: String? = null
    private var scoreCount: Int = 0
    private lateinit var teamNameTextView: TextView
    private lateinit var teamScoreTextView: TextView
    private lateinit var addOnePointBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            teamName = it.getString(ARG_NAME)
            teamScore = it.getString(ARG_SCORE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_team_score, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamNameTextView = view.findViewById(R.id.team_name_text_view)
        teamScoreTextView = view.findViewById(R.id.team_score_text_view)
        teamNameTextView.text = getString(R.string.team_name_text, teamName ?: ARG_NAME)
        teamScoreTextView.text = getString(R.string.team_score_text, teamScore)
        addOnePointBtn = view.findViewById(R.id.add_one_point_button)
        addOnClickListener()
    }

    private fun addOnClickListener() {
        addOnePointBtn.setOnClickListener {
            scoreCount++
            teamScoreTextView.text = scoreCount.toString()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param name Parameter 1.
         * @param score Parameter 2.
         * @return A new instance of fragment TeamScoreFragment.
         */
        @JvmStatic
        fun newInstance(name: String, score: String) =
            TeamScoreFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_SCORE, score)
                }
            }
    }
}