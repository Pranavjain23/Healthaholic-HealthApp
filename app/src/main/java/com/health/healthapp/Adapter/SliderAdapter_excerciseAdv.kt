package com.health.healthapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.health.healthapp.R
import com.health.healthapp.model.excerciseadv

class SliderAdapter_excerciseAdv internal constructor(
    excerciseAdvList : MutableList<excerciseadv>,
    viewPager2: ViewPager2

) : RecyclerView.Adapter<excerciseAdvAdapter.excerciseAdvViewHolder>(){

    private val excerciseAdvList : List<excerciseadv>
    private val viewPager2 : ViewPager2

    init {
        this.excerciseAdvList = excerciseAdvList
        this.viewPager2 = viewPager2
    }


    class sliderViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val cardNeedHelp : CardView = view.findViewById(R.id.cardNeedHelp)
        private val txtAdvantage : TextView = view.findViewById(R.id.txtAdvance)

        fun text(ExcerciseAdv: excerciseadv){
            txtAdvantage.text= ExcerciseAdv.txtAdvantage
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): excerciseAdvAdapter.excerciseAdvViewHolder {
        return excerciseAdvAdapter.excerciseAdvViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.stepcounter_advantage_single_row,parent,false)

        )

    }

    override fun getItemCount(): Int {
        return excerciseAdvList.size
    }
    private val runnable = Runnable {
        excerciseAdvList.addAll(excerciseAdvList)
        notifyDataSetChanged()
    }



    override fun onBindViewHolder(holder: excerciseAdvAdapter.excerciseAdvViewHolder, position: Int) {
        val ExcerciseAdv = excerciseAdvList[position]
        holder.txtAdvantage.text= ExcerciseAdv.txtAdvantage
        if(position == excerciseAdvList.size - 2){
            viewPager2.post(runnable)

        }


    }
}