package com.health.healthapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.health.healthapp.R
import com.health.healthapp.activity.gymActivity.*
import com.health.healthapp.model.gym_routine

class gym_advance_adapter(val context: Context, val list: ArrayList<gym_routine>) : RecyclerView.Adapter<gym_advance_adapter.gym_recycler>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): gym_recycler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gym_workout_routine_single_row,parent,false)

        return gym_recycler(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: gym_recycler, position: Int) {
        val gym= list[position]
        holder.exercise.text=gym.exercise

        holder.gymday.text= gym.day
        holder.gymparts.text= gym.bodyparts
        holder.linearLayoutgym.setOnClickListener {
            if(position==0){
                val i = Intent(context, Gym_Activity_advance_day1::class.java)
                context.startActivity(i)
            }
            if(position==1){
                val i = Intent(context, Gym_Activity_advance_day2::class.java)
                context.startActivity(i)
            }
            if(position==2){
                val i = Intent(context, Gym_Activity_advance_day3::class.java)
                context.startActivity(i)
            }
            if(position==3){
              Toast.makeText(context,"Enjoy your rest day",Toast.LENGTH_SHORT).show()
//                val snack = Snackbar.make( findViewById(R.id.gym),
//                    "Rest day", Snackbar.LENGTH_INDEFINITE)
//                snack.setAction("Ok") {
//                }
//                snack.show()
            }
            if(position==4){
                val i = Intent(context, Gym_Activity_advance_day5::class.java)
                context.startActivity(i)
            }
            if(position==5){
                val i = Intent(context, Gym_Activity_advance_day6::class.java)
                context.startActivity(i)
            }
            if(position==6){
                val i = Intent(context, Gym_Activity_advance_day7::class.java)
                context.startActivity(i)
            }

        }
    }

    class gym_recycler(view: View): RecyclerView.ViewHolder(view) {
        val exercise:TextView=view.findViewById(R.id.txtMainHead)

        val gymday : TextView =view.findViewById(R.id.gym_day);
        val gymparts: TextView =view.findViewById(R.id.gym_bodyparts);
        val linearLayoutgym: LinearLayout = view.findViewById(R.id.llGym)

    }

}