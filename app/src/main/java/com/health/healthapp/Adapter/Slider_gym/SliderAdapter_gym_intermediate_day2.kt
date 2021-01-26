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

class SliderAdapter_gym_intermediate_day2(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView
    lateinit var slideReps : TextView
    lateinit var slideSets : TextView

    val slide_images = arrayOf(

        R.drawable.skull_cusher,
        R.drawable.tricep_kickback,
        R.drawable.standing_barbell_curl,
        R.drawable.preacher_curl
    )

    val slide_sets = arrayOf(
        "4 sets",
        "4 sets",
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
        "Skullcrushers",
        "Tricep Kickback",
        "Standing Barbell Curl",
        "Preacher Curl"
    )

    val slide_descs = arrayOf(
        "Lie down on your back. Your feet should be flat on the floor and your legs should be bent at the knees. If you're on a bench, your head should be at one end of the bench so you have space to use your weights. On a stability ball, just balance in the middle of your back",

        "Hold a dumbbell in each hand with your palms facing in toward each other, keeping your knees bent slightly. Engage your core and maintain a straight spine as you hinge forward at the waist, bringing your torso almost parallel to the floor. Keep your upper arms in close to your body and your head in line with your spine, tucking your chin in slightly. On an exhale, engage your triceps by straightening your elbows. Hold your upper arms still, only moving your forearms during this movement. Pause here, then inhale to return the weights to the starting position.",

        "Before you pick up a weight, stand with your arms at your sides and palms facing out. Our hands will be wider than shoulder width. That should be the strongest and most joint-friendly grip for you. Now load a barbell, either on the floor or, if you’re training at home or in a mostly empty gym, the supports of a squat rack.",

        "Sit on the preacher bench with your feet firmly planted on the floor shoulder-width apart. Grip the dumbbells, barbell or machine in a supinated (underhand) grip. Your underarms should be positioned at the top of the pad. Lower the dumbbells, barbell or machine in a controlled manner until both of your elbows are fully extended. Then curl upward, keeping your shoulders and body stable throughout."

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