package com.health.healthapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.health.healthapp.R
import com.health.healthapp.model.meal_menu

class MealMenuAdapter(val context: Context, val list: ArrayList<meal_menu>) : RecyclerView.Adapter<MealMenuAdapter.meal_recycler>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): meal_recycler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meal_single_row,parent,false)

        return meal_recycler(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: meal_recycler, position: Int) {
        val mealMenu= list[position]
        holder.dishName.text= mealMenu.dishName
        holder.dishTime.text= mealMenu.dishTime
        holder.dishLevel.text= mealMenu.dishLevel
        holder.dishVeg.text= mealMenu.dishVeg
        holder.dishImage.setImageResource(mealMenu.dishImage)

    }

    class meal_recycler(view: View): RecyclerView.ViewHolder(view) {
        val dishImage : ImageView=view.findViewById(R.id.dishImage);
        val dishName : TextView =view.findViewById(R.id.dishName);
        val dishTime: TextView =view.findViewById(R.id.dishTime);
        val dishLevel : TextView =view.findViewById(R.id.dishLevel);
        val dishVeg: TextView =view.findViewById(R.id.dishVeg);

        val linearLayoutgym: LinearLayout = view.findViewById(R.id.llMeal)

    }

}