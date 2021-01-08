package com.example.healthapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healthapp.R
import com.example.healthapp.model.Diet_plan_model

class DietPlanAdapter (val context: Context, val itemList: ArrayList<Diet_plan_model>) : RecyclerView.Adapter<DietPlanAdapter.DoDontViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoDontViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_row_dietplan,parent,false)

        return DoDontViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DoDontViewHolder, position: Int) {
        val list = itemList[position]
        holder.txtHead.text = list.txtHeading
        holder.txtTime.text = list.txtTiming
        holder.txtOption1.text = list.txtOption1
        holder.txtOption2.text = list.txtOption2


    }
    class DoDontViewHolder(view: View) : RecyclerView.ViewHolder(view){

        var txtHead: TextView = view.findViewById(R.id.txt)
        var txtTime: TextView = view.findViewById(R.id.txtTime)
        var txtOption1: TextView = view.findViewById(R.id.txtOption1)
        var txtOption2: TextView = view.findViewById(R.id.txtOption2)


    }

}