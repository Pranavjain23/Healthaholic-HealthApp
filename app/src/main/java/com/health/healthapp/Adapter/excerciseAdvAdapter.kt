package com.health.healthapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.health.healthapp.R
import com.health.healthapp.model.excerciseadv
import java.util.ArrayList

class excerciseAdvAdapter (val context : Context,
                           val excerciseAdvList : ArrayList<excerciseadv>
) : RecyclerView.Adapter<excerciseAdvAdapter.excerciseAdvViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):excerciseAdvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stepcounter_advantage_single_row,parent,false)
        return excerciseAdvViewHolder(view)

    }

    override fun onBindViewHolder(holder: excerciseAdvViewHolder, position: Int) {

        val ExcerciseAdv = excerciseAdvList[position]
        holder.txtAdvantage.text= ExcerciseAdv.txtAdvantage

    }

    override fun getItemCount(): Int {
        return excerciseAdvList.size
    }
    class excerciseAdvViewHolder(view: View) : RecyclerView.ViewHolder(view){

    //    val imgAppLogo : ImageView = view.findViewById(R.id.imgAppLogo)
        val txtAdvantage : TextView = view.findViewById(R.id.txtAdvantage)


    }




}