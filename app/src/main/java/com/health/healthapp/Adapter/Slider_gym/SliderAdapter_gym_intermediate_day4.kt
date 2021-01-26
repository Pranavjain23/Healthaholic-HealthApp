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

class SliderAdapter_gym_intermediate_day4(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView
    lateinit var slideReps : TextView
    lateinit var slideSets : TextView

    val slide_images = arrayOf(

        R.drawable.barbell_front_raise,
        R.drawable.machine_reverse,
        R.drawable.barbell_shrugs,
        R.drawable.dumbell_lateral_rise
    )
    val slide_sets = arrayOf(
        "4 sets",
        "4 sets" ,
        "4 sets" ,
        "4 sets"
    )
    val slide_reps = arrayOf(
        "15 reps",
        "15 reps" ,
        "15 reps" ,
        "15 reps"
    )

    val slide_headings = arrayOf(
        "Barbell Front Raise",
        "Machine Reverse Fly",
        "Barbell Shrugs" ,
        "One Arm Cable Lateral Raise"
    )

    val slide_descs = arrayOf(
        "Set an adjustable bench to an incline of 30-45 degrees. Lie on your back on the bench and hold a pair of dumbbells directly above your shoulders with your arms fully extended. Pull your shoulder blades together, and slightly stick out your chest. Lower both dumbbells to the sides of your chest.",

        "Sit up tall and relax your neck and shoulders. Your feet should be flat on the floor. Grab the handles so that your palms are facing forward. Note that some machines have a foot bar that you need to push in order to release the handles and bring them forward. Press your arms together in front of your chest with a slow, controlled movement. Keep a slight, soft bend in the elbows with wrists relaxed. Pause for one second once your arms are fully \"closed\" in front of your chest. Bring your arms slowly back to the starting position, opening your chest and keeping posture strong and upright.",

        "Standing with your feet shoulder-width apart, place a barbell in front of your thighs, hands shoulder-width apart, palms facing your body, and arms fully extended. Keeping your arms straight, shrug your shoulders as high as you can. Pause, then lower to the start position.",

        "Hold one dumbbell by your side and one in front. Lift to the side and front simultaneously. Lower back down under control. Alternate sides with each rep.")


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