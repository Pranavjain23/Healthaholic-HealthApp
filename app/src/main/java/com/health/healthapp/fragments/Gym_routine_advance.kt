package com.health.healthapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.health.healthapp.Adapter.gym_advance_adapter
import com.health.healthapp.R
import com.health.healthapp.model.gym_routine


class Gym_routine_advance : Fragment() {
    lateinit var recyclerView : RecyclerView
    lateinit var layoutManager_gym : RecyclerView.LayoutManager
    lateinit var recyclerAdapter: gym_advance_adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gym_routine, container, false)
        recyclerView = view.findViewById(R.id.recycler_gym)
        layoutManager_gym = LinearLayoutManager(activity)
        val listofDays = arrayListOf<gym_routine>()

        listofDays.add(
            gym_routine("Day 1","Upper Body","Chest + Back")
        )
        listofDays.add(
            gym_routine("Day 2","Lower body","Legs")
        )

        listofDays.add(
            gym_routine("Day 3","Workout","Shoulders + Arms")
        )
        listofDays.add(
            gym_routine("Day 4","Rest Day","Take your rest")
        )
        listofDays.add(
            gym_routine("Day 5","Muscles","Chest + Shoulders + Triceps")
        )
        listofDays.add(
            gym_routine("Day 6","Upper Body","Back + Biceps")
        )
        listofDays.add(
            gym_routine("Day 7","Lower Body","Legs")
        )

        recyclerAdapter = gym_advance_adapter(activity as Context,listofDays)
        recyclerView.layoutManager = layoutManager_gym
        recyclerView.adapter = recyclerAdapter

        return view
    }

}