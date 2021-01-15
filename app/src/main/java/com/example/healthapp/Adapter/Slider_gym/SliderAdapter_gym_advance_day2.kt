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

class SliderAdapter_gym_advance_day2 (val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideReps : TextView
    lateinit var slideSets : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(

        R.drawable.squat,
        R.drawable.legpress,
        R.drawable.stiffed_legged_deadlift,
        R.drawable.hamstring_curls,
        R.drawable.calves

    )

    val slide_headings = arrayOf(
        "Squats",
        "Leg Press " ,
        "Stiff-Legged Deadlift" ,
        "Hamstring Curls ",
        "Calf-Raise "
    )
    val slide_sets = arrayOf(
        "3 sets",
        "3 sets",
        "5 sets" ,
        "3 sets " ,
        "5 sets"
    )
    val slide_reps = arrayOf(
        "20 reps",
        "10 reps",
        "5 reps" ,
        "5-8 reps" ,
        "10 reps"
    )

    val slide_descs = arrayOf(
        "Stand with your feet slightly wider than your hips. Your toes should be pointed slightly outward – about 5 to 20 degrees outward (the wider your stance, the more you’ll want to rotate your feet outward).\nLook straight ahead and pick a spot on the wall in front of you. Look at this spot the entire time you squat, not looking down at the floor or up at the ceiling.",
        "In the incline leg press machine, you sit in a low, reclined seat with your feet pressed up against a raised platform. You can add weight plates to the platform to adjust the resistance and make it more difficult to push the platform up and away from you",

        "Stand with your feet shoulder-width apart holding a barbell in an overhand grip (palms facing you). Your knees should be slightly bent and the aim is to maintain this slight degree of flex throughout the movement. Bend at your hips and lower the barbell, keeping your back straight.",
        " Lie on your stomach, hook the back of your lower legs around a lever attached to a weight stack and pull the weight toward your buttocks, trying to bring your heels as close to your gluteal muscles as possible.",
        "Start in a standing position with your feet at hip width and your arms by your sides. Keep a straight back and good upright posture, looking straight ahead. From here, contract your calf muscles, hamstrings and glutes so that you raise up on to your toes by lifting your heels up as high as you can."
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