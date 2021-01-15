package com.example.healthapp.Adapter.Slider_gym

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.healthapp.R

class SliderAdapter_gym_intermediate_day1(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView
    lateinit var slideReps : TextView
    lateinit var slideSets : TextView

    val slide_images = arrayOf(

        R.drawable.incline_bench_press,
        R.drawable.skull_cusher,
        R.drawable.barbell_front_raise
    )

    val slide_headings = arrayOf(
        "Incline Dumbbell Bench Press",
        "Skullcrushers",
        "Barbell Front Raise"
    )
    val slide_sets = arrayOf(
        "4 sets",
        "4 sets" ,
        "4 sets"
    )
    val slide_reps = arrayOf(
        "15 reps",
        "15 reps" ,
        "15 reps"
    )

    val slide_descs = arrayOf(
        "Set an adjustable bench to an incline of 30-45 degrees. Lie on your back on the bench and hold a pair of dumbbells directly above your shoulders with your arms fully extended.\nPull your shoulder blades together, and slightly stick out your chest. Lower both dumbbells to the sides of your chest.",
        "Lie down on your back.\nYour feet should be flat on the floor and your legs should be bent at the knees.\nIf you're on a bench, your head should be at one end of the bench so you have space to use your weights.\nOn a stability ball, just balance in the middle of your back",
        "In this version of the dumbbell front raise, you start with a dumbbell in each hand at thigh level.\nYou raise the dumbbells parallel to the floor and then return to the starting position to complete one exercise repetition.\nYou can use this exercise in an upper body workout to build your shoulder strength.")



    override fun getCount(): Int {
        return slide_headings.size
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater.inflate(R.layout.slider_gym_layout, container, false)

        slideImageView =  view.findViewById(R.id.imgYogaPose)
        slideHeading = view.findViewById(R.id.txtYogaName)
        slideSets = view.findViewById(R.id.txtYogaSets)
        slideReps = view.findViewById(R.id.txtYogaReps)
        slideDescription= view.findViewById(R.id.txtYogaDesc)

        slideImageView.setImageResource(slide_images[position])
        slideHeading.text = slide_headings[position]
        slideSets.text = slide_sets[position]
        slideReps.text = slide_reps[position]
        slideDescription.text = slide_descs[position]

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }

}