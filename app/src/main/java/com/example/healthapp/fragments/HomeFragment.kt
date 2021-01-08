package com.example.healthapp.fragments

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.healthapp.R
import com.example.healthapp.activity.BmiActivity
import com.example.healthapp.activity.DevelopedByActivity
import com.example.healthapp.activity.MainActivity
import com.example.healthapp.activity.StepCounterActivity


class HomeFragment : Fragment() {

    lateinit var btnStepcounter : CardView
    lateinit var btnBMI : CardView
    lateinit var dietPlan : Button

    lateinit var breakfastCard : CardView
    lateinit var lunchCard : CardView
    lateinit var dinnerCard : CardView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        dietPlan = view.findViewById(R.id.dietPlan)
        btnStepcounter = view.findViewById(R.id.btnStepCounter)
        btnBMI = view.findViewById(R.id.btnBMI)
        breakfastCard=view.findViewById(R.id.breakfastCard)
        lunchCard=view.findViewById(R.id.lunchCard)
        dinnerCard=view.findViewById(R.id.dinnerCard)

        btnStepcounter.setOnClickListener {
            val intent = Intent(context, StepCounterActivity::class.java)
            startActivity(intent)
        }
        btnBMI.setOnClickListener {
            val intent = Intent(context, BmiActivity::class.java)
           startActivity(intent)
        }

        dietPlan.setOnClickListener {
            val fragment = DietPlan()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }


        breakfastCard.setOnClickListener {
            val fragment = MealMenuFragment()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }
        lunchCard.setOnClickListener {
            val fragment = MealMenuFragment()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }
        dinnerCard.setOnClickListener {
            val fragment = MealMenuFragment()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }


        return view
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_information, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.info){
            val intent = Intent(context, DevelopedByActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}