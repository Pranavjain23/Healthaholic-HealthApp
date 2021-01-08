package com.example.healthapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthapp.Adapter.MealMenuAdapter
import com.example.healthapp.R
import com.example.healthapp.model.meal_menu

class MealMenuFragment : Fragment() {

    lateinit var recyclerView : RecyclerView
    lateinit var llMeal : RecyclerView.LayoutManager
    lateinit var recyclerAdapter: MealMenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_meal_menu, container, false)

        recyclerView = view.findViewById(R.id.recycler_meal_menu)
        llMeal = LinearLayoutManager(activity)
        val listofMeals = arrayListOf<meal_menu>()

        listofMeals.add(meal_menu(R.drawable.lunch,"Butternut squash curry","50 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.breakfast,"Chickpeas & poached eggs","15 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.dinner,"Indian potato pie","1 hr and 35 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.lunch,"Indian summer salad","20 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.lunch,"Indian winter soup","45 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.lunch,"Gujrati Thepla","1 hr and 15 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.lunch,"Indian cucumber salad","10 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.lunch,"Fish curry with chickpeas","35 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.lunch,"Sweet potato & dhal pies","40 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.lunch,"Broccoli & carrot salad","30 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.lunch,"South Indian fish curry","40 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.lunch,"Vegetable chapati wraps","30 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.lunch,"Chicken tikka skewers","40 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.lunch,"Chicken jalfrezi","1 hr and 10 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.lunch,"Chicken madras","50 mins","Easy","Non Vegetarian"))





        recyclerAdapter = MealMenuAdapter(activity as Context,listofMeals)
        recyclerView.layoutManager = llMeal
        recyclerView.adapter = recyclerAdapter

        return view
    }

}