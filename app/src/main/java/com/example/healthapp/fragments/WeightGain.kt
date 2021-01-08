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
            Diet_plan_model("Early Morning Snack"," Between 5:00 a.m. to 6:00 a.m. ","1 glass milk with 2 teaspoons of skimmed milk powder, 2 whole ripe bananas, and 5 to 10 pieces of overnight soaked almonds with peel","1 cup of tea or cappuccino loaded with sugar and full-fat milk, white portions of 2 eggs, and 6 to 7 pieces of overnight soaked almonds with peel")
        )
        gainArrayList.add(
            Diet_plan_model("Breakfast ","Between 7:00 a.m. to 9:00 a.m. ","3 to 4 slices of whole wheat bread toast with peanut butter, 3 egg whites, and 1 full egg omelet","1 large bowl of oats/wheat bran/corn flakes (add fruits if you wish), 1 chicken breast, and 1 glass full of banana milkshake")
        )
        gainArrayList.add(
            Diet_plan_model("Mid-Morning Snack","Between 10:00 a.m. to 11:00 a.m. ","1 glass of fresh juice and 1 plate of salad with 2 boiled potatoes ","1 fresh whole seasonal fruit (of your choice) and 1 glass of buttermilk/plain lassi/coconut water")
        )
        gainArrayList.add(
                Diet_plan_model("⚫ Lunch ","Between 12:30 p.m. to 1:30 p.m. ","1 small bowl of pulav/biriyani (non-veg), 1 small bowl of egg/paneer, 1 small bowl of vegetables (as per your choice) and 1 medium-sized bowl of chicken soup/sprout salad,","2 small bowls of plain rice, 2 medium-sized chapattis with ghee, 1 small bowl of legumes / dal (mung, chana, masoor or soybean), 2 small bowls of wet vegetable curry (as per your choice), 2 medium-sized pieces of chicken/fish, 1 plate of green salad and 1 small bowl of sweet curd/raita ")
        )
        gainArrayList.add(
            Diet_plan_model("⚫ Evening Snack ","Between 4:30 p.m. to 5:30 p.m. ","1 fresh seasonal fruit and a small bowl of mixed sprout salad","1 glass banana shake/tea/coffee and 4 cookies")
        )
        gainArrayList.add(
            Diet_plan_model("⚫ Pre-Dinner","Between 5:30 p.m. to 6:30 p.m.","1 whole wheat bread sandwich with steamed chicken/3 egg whites","1 medium-sized bowl of vegetable/chicken soup (with butter) and 1 veg sandwich with mayonnaise or extra cheese")
        )
        gainArrayList.add(
            Diet_plan_model("⚫ Dinner ","Between 8:30 p.m. to 9:30 p.m. ","1 small bowl of brown rice/2 whole wheat chapattis, 1 small bowl of stir-fried vegetables with baked potato, and 1 small piece of lean chicken/fish","3 medium-sized chapattis with ghee, 1 small bowl of legumes/dal (moong, chana, masoor or soybean), 1 small bowl of dry vegetable curry (as per your choice), 1 small bowl of chicken/fish, and 1 small bowl of curd/any other sweet dish")
        )

        gainArrayList.add(
            Diet_plan_model("⚫ Late Night Snack","Between 10:30 p.m. to 11:30 p.m. ","1 glass full of warm milk with 1 teaspoon of raw honey and a pinch of turmeric added to it","(1/2) a glass of skimmed milk with 1 to 2 teaspoons of whey protein ")
        )


        recyclerAdapter = DietPlanAdapter(activity as Context, gainArrayList)

        recycler.adapter = recyclerAdapter
        recycler.layoutManager = layoutManager
        return view
    }


}