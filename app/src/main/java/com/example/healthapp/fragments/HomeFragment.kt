package com.example.healthapp.fragments

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.healthapp.R
import com.example.healthapp.activity.*


class HomeFragment : Fragment() {

    lateinit var btnStepcounter : CardView
    lateinit var btnBMI : CardView
    lateinit var dietPlan : Button
    lateinit var img1:ImageView
    lateinit var img2:ImageView
    lateinit var img3:ImageView
    lateinit var img4:ImageView
    lateinit var img5:ImageView
    lateinit var breakfastCard : CardView
    lateinit var lunchCard : CardView
    lateinit var dinnerCard : CardView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        setHasOptionsMenu(true)

        dietPlan = view.findViewById(R.id.dietPlan)
        btnStepcounter = view.findViewById(R.id.btnStepCounter)
        btnBMI = view.findViewById(R.id.btnBMI)
        breakfastCard=view.findViewById(R.id.breakfastCard)
        lunchCard=view.findViewById(R.id.lunchCard)
        dinnerCard=view.findViewById(R.id.dinnerCard)
        img1=view.findViewById(R.id.img1)
        img2=view.findViewById(R.id.img2)
        img3=view.findViewById(R.id.img3)
        img4=view.findViewById(R.id.img4)
        img5=view.findViewById(R.id.img5)


        img1.setOnClickListener {
            val fragment = PhysicalFragment()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }
        img2.setOnClickListener {
            val fragment = SocialFragment()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }
        img3.setOnClickListener {
            val fragment = SpiritualFragment()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }
        img4.setOnClickListener {
            val fragment = EmotionalFragment()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }
        img5.setOnClickListener {
            val fragment = IntellectualFragment()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }

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
        if(item.itemId == R.id.feedbackUser){
//            val intent = Intent(context, FormFeedbackFragment::class.java)
//            startActivity(intent)
            val fragment = FormFeedbackFragment()
            val args = Bundle()
            fragment.arguments = args
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame,
                    fragment
                ).commit()
        }

        return super.onOptionsItemSelected(item)
    }
}