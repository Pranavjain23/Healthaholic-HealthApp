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

class SliderAdapter_gym_advance_day1(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideReps : TextView
    lateinit var slideSets : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(

        R.drawable.barbell_bench_press,
        R.drawable.incline_bench_press,
        R.drawable.dips,
        R.drawable.pullups,
        R.drawable.pendlay_row,
        R.drawable.pulldown
    )

    val slide_headings = arrayOf(
        "Barbell Bench Press",
        "Incline Dumbbell Press",
        "Dips " ,
        "Pullups " ,
        "Pendlay Rows" ,
        "Pulldowns "
    )
    val slide_sets = arrayOf(
        "3 sets",
        "3 sets",
        "3 sets" ,
        "3 sets " ,
        "3 sets" ,
        "3 sets"
    )
    val slide_reps = arrayOf(
        "12 reps",
        "15 reps",
        "6-10 reps" ,
        "5-8 reps" ,
        "6-10 reps" ,
        "10-15 reps"
    )

    val slide_descs = arrayOf(
        "Lie on the bench with your eyes under the bar. Grab the bar with a medium grip-width (thumbs around the bar!). Unrack the bar by straightening your arms. Lower the bar to your mid-chest. Press the bar back up until your arms are straight. Hold the weight for a second at the top, with straight arms. Breathe. Then take a big breath, hold it, and lower the bar again. Keep your butt on the bench when you press it back up.",
        "Position your body on an incline bench on a 30-45 degree angle. Grab a barbell with an overhand grip that's shoulder-width apart and hold it above your chest. ... Lower the bar straight down in a slow, controlled movement to your chest. Pause, then press the bar in a straight line back up to the starting position",
        "Lean forward. Put your elbows a little bit wider than your shoulders. Move knees slightly forward, so your body is shaped like a \"C\" Contract your abs to maintain the position. Keep your head in line with your spine as you go down.",
        "Grasp the bar with an overhand grip with your hands just wider than shoulder-width apart. Let your body hang straight down with your arms fully extended. Pull up and squeeze your lats until your chin is over the bar, before lowering slowly to the start position without swinging.",
        "Bend forwards, hinging at the hips, until your back is parallel to the ground. Your knees should be slightly bent. Grasp the bar using an overhand grip with your hands just wider than shoulder-width apart. Brace your core and lift the weight up to your abdomen by squeezing your shoulder blades together.",
        "Grasp the bar with a wide grip with an overhand, knuckles up grip. Other positions and grips are possible but start with this standard position. Pull the bar down until it's approximately level with the chin. Exhale on down motion. "

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