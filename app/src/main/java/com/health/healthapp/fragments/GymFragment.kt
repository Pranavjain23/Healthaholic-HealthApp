package com.health.healthapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.health.healthapp.R
import com.health.healthapp.activity.MainActivity


class GymFragment : Fragment() {
       lateinit var beginner: CardView
      lateinit var intermeditae: CardView
        lateinit var advanced: CardView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gym, container, false)
        beginner=view.findViewById(R.id.beginner)
        intermeditae=view.findViewById(R.id.intermediate)
        advanced=view.findViewById(R.id.advance)

        beginner.setOnClickListener {
            val fragment = Gym_routine_beginner()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }
        intermeditae.setOnClickListener {
            val fragment = Gym_routine_intermediate()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }
        advanced.setOnClickListener {
            val fragment = Gym_routine_advance()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }

        return view
    }


}