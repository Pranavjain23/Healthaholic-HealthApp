package com.health.healthapp.fragments

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.health.healthapp.Adapter.TabAdapter
import com.health.healthapp.R
import com.health.healthapp.activity.MainActivity
import com.google.android.material.tabs.TabLayout


class DietPlan : Fragment() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    private lateinit var myContext: MainActivity

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        myContext = activity as MainActivity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_diet_plan, container, false)

        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager = view.findViewById(R.id.viewPager)

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter= TabAdapter(context, childFragmentManager)

        viewPager.adapter = adapter

        tabLayout.setupWithViewPager(viewPager)
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ec407a"))
        return view
    }


}