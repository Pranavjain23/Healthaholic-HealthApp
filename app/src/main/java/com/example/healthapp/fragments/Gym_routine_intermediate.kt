package com.example.healthapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthapp.Adapter.gym_intermediate_adapter
import com.example.healthapp.R
import com.example.healthapp.model.gym_routine


class Gym_routine_intermediate : Fragment() {
    lateinit var recyclerView : RecyclerView
    lateinit var layoutManager_gym : RecyclerView.LayoutManager
    lateinit var recyclerAdapter: gym_intermediate_adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gym_routine, container, false)
        recyclerView = view.findViewById(R.id.recycler_gym)
        layoutManager_gym = LinearLayoutManager(activity)
        val listofDays = arrayListOf<gym_routine>()

        listofDays.add(
            gym_routine("Day 1","Exercise","Chest + Back")
        )
        listofDays.add(
            gym_routine("Day 2","Exercise","Biceps + Triceps")
        )

        listofDays.add(
            gym_routine("Day 3","Exercise","Legs")
        )
        listofDays.add(
            gym_routine("Day 4","Exercise","Shoulders")
        )
        listofDays.add(
            gym_routine("Day 5","Exercise","Back + Biceps")
        )

        recyclerAdapter = gym_intermediate_adapter(activity as Context,listofDays)
        recyclerView.layoutManager = layoutManager_gym
        recyclerView.adapter = recyclerAdapter

        return view
    }

}