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

class SliderAdapter_gym_advance_day6(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView
    lateinit var slideReps : TextView
    lateinit var slideSets : TextView

    val slide_images = arrayOf(

        R.drawable.barbell_row,
        R.drawable.barbell_shrugs,
        R.drawable.rack_pulls,
        R.drawable.pullups,
        R.drawable.pulldown
    )

    val slide_sets = arrayOf(
        "5 sets",
        "3 sets",
        "3 sets" ,
        "3 sets" ,
        "3 sets"
    )
    val slide_reps = arrayOf(
        "12 reps",
        "15 reps",
        "6-10 reps" ,
        "6-10 reps" ,
        "10 reps"
    )
    val slide_headings = arrayOf(
        "Barbell Rows " ,
        "Barbell Shrugs " ,
        "Rack Deadlifts" ,
        "Pullups " ,
        "Pulldowns"

    )

    val slide_descs = arrayOf(
        "Stand with your mid-foot under the bar. Bend over and grab the bar (palms down, medium-grip).Unlock your knees while keeping your hips high. Lift your chest and straighten your back. Pull the bar against your lower chest. ",
        "Standing with your feet shoulder-width apart, place a barbell in front of your thighs, hands shoulder-width apart, palms facing your body, and arms fully extended. Keeping your arms straight, shrug your shoulders as high as you can. Pause, then lower to the start position.",
        "When the bar is in your favoured position, grasp it with your palms facing towards you and your hands shoulder-width apart. Engage your hamstrings by pushing your hips back. Keeping your back straight and looking forwards throughout the movement, lift the weight by driving your hips forwards and straightening your knees. Pull your shoulders back at the top of the movement, then slowly reverse the movement and lower the bar back into the power rack.",
        "Grab The Bar. Grip it about shoulder-width apart. Hang. Raise your feet off the floor by bending your knees. Pull yourself up by pulling your elbows down to the floor. Pass The bar. Pull yourself all the way up until your chin passes the bar. Repeat. Lower yourself all the way down until your arms are straight.",
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