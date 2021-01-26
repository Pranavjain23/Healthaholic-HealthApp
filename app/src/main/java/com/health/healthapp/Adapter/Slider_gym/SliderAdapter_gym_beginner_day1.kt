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

class SliderAdapter_gym_beginner_day1(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView
    lateinit var slideReps : TextView
    lateinit var slideSets : TextView

    val slide_images = arrayOf(

        R.drawable.barbell_bench_press,
        R.drawable.latpulldown,
        R.drawable.seateddumbell,
        R.drawable.leg_extension,
        R.drawable.barbellbicepcurls,
        R.drawable.tricepropepushdown
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
        "8 reps",
        "10 reps",
        "10 reps" ,
        "10 reps" ,
        "10 reps" ,
        "15 reps"
    )
    val slide_headings = arrayOf(
        "Barbell Bench Press",
        "Lat-pulldowns",
        "Seated Dumbbell Press",
        "Leg Extensions",
        "Barbell Bbicep Curls",
        "Triceps Rope Pushdowns"
    )

    val slide_descs = arrayOf(
        "Lie on the bench with your eyes under the bar. Grab the bar with a medium grip-width. Unrack the bar by straightening your arms. Lower the bar to your mid-chest. Press the bar back up until your arms are straight. Hold the weight for a second at the top, with straight arms. Breathe. Then take a big breath, hold it, and lower the bar again. Keep your butt on the bench when you press it back up.",

        "Grasp the bar with a wide grip with an overhand, knuckles up grip. Pull the bar down until it's approximately level with the chin. Exhale on down motion. While shifting just slightly backward is OK, aim to keep your upper torso stationary. Keep your feet flat on the floor and engage your abs as you pull. The bottom of the motion should be where your elbows can't move downward any more without moving backward. Be sure to stop at that point and do not go lower. Squeeze the shoulder blades together while maintaining square shoulders. From the bottom position with the bar close to your chin, slowly return the bar to the starting position while controlling its gradual ascent.",

        "Set up an adjustable angle bench to 90 degrees and select the desired weight from the rack. Pick up the dumbbells from the floor using a neutral grip (palms facing in). Position the end of the dumbbells on your knees and sit down on the bench. Once the dumbbells are in place, rotate your palms so they are facing forward. Take a deep breath then press the dumbbells overhead by extending the elbows and contracting the deltoids. Slowly lower the dumbbells back to the starting position (the arms should be roughly 90 degrees or slightly lower depending upon limb lengths).",

        "Place your hands on the hand bars. Lift the weight while exhaling until your legs are almost straight. Do not lock your knees. Keep your back against the backrest and do not arch your back. Exhale and lower the weight back to starting position.",

        "Stand tall with your chest up and core braced, holding the barbell with your hands just outside of your hips, using an underhand grip. Keeping your chest up and your elbows tight to your sides, initiate the move by raising your hands slightly so you feel your biceps become engaged. While maintaining tension on your biceps, curl the bar up to shoulder height, then give your biceps a one-second squeeze. Start to lower the bar slowly, keeping your biceps tensed and engaged to work as many muscle fibres as possible. Once the bar is back in the start position, straighten your arms fully to tense your triceps to ensure that your biceps are worked through the fullest possible range of motion.",

        "Start by bracing your abdominals. Tuck your elbows in at your sides and position your feet slightly apart. Inhale. Push down until your elbows are fully extended but not yet in the straight, locked position. Keep your elbows close to your body and bend your knees slightly on the pushdown. Resist bending forward. Try to keep your back as straight as possible as you push down.As you exhale, return to the starting point using a controlled movement. Try not to crash the weights."
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