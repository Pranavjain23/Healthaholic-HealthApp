package com.example.healthapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.healthapp.R
import com.example.healthapp.activity.HomeWorkoutActivity

class HomeWorkoutFragment : Fragment() {
    lateinit var btnHomeWorkout : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_home_workout, container, false)

        btnHomeWorkout = view.findViewById(R.id.btnHomeWorkout)

        btnHomeWorkout.setOnClickListener{
            val intent = Intent(context, HomeWorkoutActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}