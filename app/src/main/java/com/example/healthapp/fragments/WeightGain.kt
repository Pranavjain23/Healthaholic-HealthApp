package com.example.healthapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthapp.Adapter.DietPlanAdapter
import com.example.healthapp.R
import com.example.healthapp.model.Diet_plan_model


class WeightGain : Fragment() {
    lateinit var recycler: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter: DietPlanAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_weight_gain, container, false)
        recycler=view.findViewById(R.id.gainRecycler)
        layoutManager = LinearLayoutManager(activity)
        val gainArrayList= arrayListOf<Diet_plan_model>()

        gainArrayList.add(
            Diet_plan_model("⚫ eat xyzzzzzzzzz","Between 8-9 ","option1 gain weight ","option2 gain weight ")
        )
        gainArrayList.add(
            Diet_plan_model("⚫ eat xyzzzzzzzzz","Between 8-9 ","option1 gain weight ","option2 gain weight ")
        )
        gainArrayList.add(
            Diet_plan_model("⚫ eat xyzzzzzzzzz","Between 8-9 ","option1 gain weight ","option2 gain weight ")
        )
        gainArrayList.add(
                Diet_plan_model("⚫ eat xyzzzzzzzzz","Between 8-9 ","option1 gain weight ","option2 gain weight ")
        )
        gainArrayList.add(
            Diet_plan_model("⚫ eat xyzzzzzzzzz","Between 8-9 ","option1 gain weight ","option2 gain weight ")
        )

        recyclerAdapter = DietPlanAdapter(activity as Context, gainArrayList)

        recycler.adapter = recyclerAdapter
        recycler.layoutManager = layoutManager
        return view
    }


}