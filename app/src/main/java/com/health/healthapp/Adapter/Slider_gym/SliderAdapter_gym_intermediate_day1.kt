package com.health.healthapp.Adapter.Slider_gym

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.health.healthapp.R

class SliderAdapter_gym_intermediate_day1(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView
    lateinit var slideReps : TextView
    lateinit var slideSets : TextView

    val slide_images = arrayOf(

        R.drawable.incline_bench_press,
        R.drawable.barbell_bench_press,
        R.drawable.latpulldown,
        R.drawable.pullups,
        R.drawable.pulldown
    )

    val slide_headings = arrayOf(

        "Incline Dumbbell Bench Press",
        "Barbell Bench Press",
        "Lat Pull Down",
        "Pullups" ,
        "Pulldowns"
    )
    val slide_sets = arrayOf(
        "4 sets",
        "4 sets" ,
        "4 sets",
        "3 sets" ,
        "3 sets"
    )
    val slide_reps = arrayOf(
        "15 reps",
        "15 reps" ,
        "15 reps",
        "10 reps" ,
        "10 reps"
    )

    val slide_descs = arrayOf(
        "Set an adjustable bench to an incline of 30-45 degrees. Lie on your back on the bench and hold a pair of dumbbells directly above your shoulders with your arms fully extended. Pull your shoulder blades together, and slightly stick out your chest. Lower both dumbbells to the sides of your chest.",
        "Lie on the bench with your eyes under the bar. Grab the bar with a medium grip-width (thumbs around the bar!). Unrack the bar by straightening your arms. Lower the bar to your mid-chest. Press the bar back up until your arms are straight. Hold the weight for a second at the top, with straight arms. Breathe. Then take a big breath, hold it, and lower the bar again. Keep your butt on the bench when you press it back up.",
        "Keep your chin back and chest up as you pull the bar down, squeezing your shoulder blades down and back. Pause at the bottom of the movement (when the bar is at chest height), and then raise the bar as high as you can go. That's the movement!",
        "Grab The Bar. Grip it about shoulder-width apart. Hang. Raise your feet off the floor by bending your knees. Pull. Pull yourself up by pulling your elbows down to the floor. Pass The bar. Pull yourself all the way up until your chin passes the bar. Repeat. Lower yourself all the way down until your arms are straight.",
        "Hold a short bar above your head with an overhand grip, palms facing forwards. Pull the bar down by bringing your elbows in to your sides. Then press the bar down, keeping your elbows by your sides. Reverse the movement to return to the starting position."
    )



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