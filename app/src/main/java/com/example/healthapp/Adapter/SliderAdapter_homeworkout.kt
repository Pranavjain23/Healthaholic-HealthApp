package com.example.healthapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.healthapp.R

class SliderAdapter_homeworkout(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(
        R.drawable.yogapose,
        R.drawable.yogapose,
        R.drawable.yogapose,
        R.drawable.yogapose,
        R.drawable.yogapose,
        R.drawable.yogapose,
        R.drawable.yogapose,
        R.drawable.yogapose,
        R.drawable.yogapose,
        R.drawable.yogapose
    )

    val slide_headings = arrayOf(
        "PRESS UP",
        "SKIPPING",
        "BURPEES",
        "JUMPING LUNGES",
        "Spiderman Press-Up",
        "PLANK",
        "DEADBUG",
        "CRUNCHES",
        "BACK EXTENSION",
        "SHADOW BOXING"
    )

    val slide_descs = arrayOf(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""




    )


    override fun getCount(): Int {
        return slide_headings.size
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater.inflate(R.layout.slider_home_workout_layout, container, false)

        slideImageView =  view.findViewById(R.id.imgHomeWorkoutPose)
        slideHeading = view.findViewById(R.id.txtHomeWorkoutName)
        slideDescription= view.findViewById(R.id.txtHomeWorkoutDesc)

        slideImageView.setImageResource(slide_images[position])
        slideHeading.text = slide_headings[position]
        slideDescription.text = slide_descs[position]

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }



}