package com.health.healthapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.health.healthapp.Adapter.MealMenuAdapter
import com.health.healthapp.R
import com.health.healthapp.model.meal_menu

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

        listofMeals.add(meal_menu(R.drawable.food1,"Butternut squash curry","50 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food2,"Chickpeas & poached eggs","15 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food3,"Indian potato pie","1 hr and 35 mins","Moderate","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food4,"Indian summer salad","20 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food5,"Indian winter soup","45 mins","Easy","Vegan"))
        listofMeals.add(meal_menu(R.drawable.food6,"Gujrati Thepla","1 hr and 15 mins","Moderate","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food7,"Indian cucumber salad","10 mins","Easy","Vegan"))
        listofMeals.add(meal_menu(R.drawable.food8,"Fish curry with chickpeas","35 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food9,"Sweet potato & dhal pies","40 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food10,"Broccoli & carrot salad","30 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food11,"South Indian fish curry","40 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food12,"Vegetable chapati wraps","30 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food13,"Chicken tikka skewers","40 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food14,"Chicken jalfrezi","1 hr and 10 mins","Moderate","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food15,"Chicken madras","50 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food16,"Easy veggie biryani","20 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food17,"Onion & butternut bhajis","32 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food18,"Prawn jalfrezi","32 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food19,"Cauliflower,paneer curry","55 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food20,"Bombay lamb wraps","55 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food21,"Chicken tikka masala","1 hour 35 mins","Moderate","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food22,"Low-fat chicken biryani","2 hours","Moderate","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food23,"Chana masala","35 mins","Easy","Vegan"))
        listofMeals.add(meal_menu(R.drawable.food24,"Curried chickpeas","30 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food25,"Stir-fried mushrooms","55 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food26,"Roti potato wraps","50 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food27,"Tomato kachumber","15 mins","Easy","Vegan"))
        listofMeals.add(meal_menu(R.drawable.food28,"Spicy cauliflower","30 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food29,"Potato tamarind salad","40 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food30,"Curried chickpea cake","12 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food31,"Spiced basmati rice","1 hour 5 mins","Moderate","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food32,"Creamy chicken mango curry","1 hour 10 mins","Moderate","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food33,"Chicken masala skewers","30 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food34,"Tandoori tilapia","30 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food35,"Roast cauliflower","1 hour","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food36,"Cabbage with potato ","30 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food37,"Tomato & tamarind fish curry","35 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food38,"Spicy cauliflower pilau","15 mins","Easy","Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food39,"Chicken, potato & bean curry","40 mins","Easy","Non Vegetarian"))
        listofMeals.add(meal_menu(R.drawable.food40,"Vegetable vegan biriyani","1 hour 10 mins","Moderate","Vegan"))
        listofMeals.add(meal_menu(R.drawable.food41,"Chicory & orange salad","30 mins","Easy","Non Vegetarian"))


        recyclerAdapter = MealMenuAdapter(activity as Context,listofMeals)
        recyclerView.layoutManager = llMeal
        recyclerView.adapter = recyclerAdapter

        return view
    }

}