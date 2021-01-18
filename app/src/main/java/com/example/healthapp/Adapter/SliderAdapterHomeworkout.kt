package com.example.healthapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.healthapp.R

class SliderAdapterHomeworkout(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(
        R.drawable.press_up,
        R.drawable.skipping,
        R.drawable.burpee,
        R.drawable.jumping_lunges,
        R.drawable.spiderman_pressup,
        R.drawable.plank,
        R.drawable.deadbug,
        R.drawable.crunches,
        R.drawable.pronebackextension,
        R.drawable.shadowbox
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
        "Get down on all fours, placing your hands slightly wider than your shoulders. Straighten your arms and legs. Lower your body until your chest nearly touches the floor. Pause, then push yourself back up. Repeat.",
        "Start with your hands in the \"ready\" position. Grip the handles loosely with your fingers, not your palms. Practice a toe catch. Place the rope behind you and turn the jump rope over your head. Pretend jump. Practice timing.",
        "Stand with your feet shoulder-width apart and your arms by your sides. Lower into a squat position and place your hands on the floor. Kick or step your legs back into a plank position. Return to the standing position.",
        "Starting standing with feet shoulder-width apart. Jump your left leg forward and your right leg back into a lunge, with both knees at 90 degrees. Jump up and switch your legs in midair so that you land in a lunge with your right leg in front. Continue jumping back and forth, pausing as little as possible",
        "Assume a standard pushup position, your body aligned from ankles to head. As you lower your body toward the floor, lift your right foot, swing your right leg out sideways, and try to touch your knee to your elbow. Return to the starting position, and repeat with your left leg",
        "Get into forearm plank position. Ensure your elbows on the ground directly underneath your shoulders with your feet hip-width apart. Make sure your back is flat and your head and neck are in a neutral position. Drive your elbows into the floor, and squeeze your quads, glutes, and core.",
        "The dead bug exercise involves lying face up on your mat with your arms in the air above your torso and your legs in the air with your knees bent at 90-degree angles. Then, you lower opposite arm and leg toward the floor in a slow and controlled fashion. Return to center and then repeat on the other side.",
        "Lie down on your back. Plant your feet on the floor, hip-width apart. Bend your knees and place your arms across your chest. Contract your abs and inhale. Exhale and lift your upper body, keeping your head and neck relaxed. Inhale and return to the starting position.",
        "Lie on a mat on your stomach and straighten your legs behind you. Place your elbows on the ground and slide your shoulders down. Lift your upper back, pressing your hips into the mat. Keep your head and neck neutral. Hold for 30 seconds. Lower to starting position. ",
        "You might think of shadowboxing as more of a warm-up than an exercise, but it's actually a great full-body workout. During these rounds, you're working your chest, shoulders, arms, and leg muscles. It burns calories and is a great way for beginners to build-up some muscle mass."


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

        Glide.with(slideImageView).load(slide_images[position]).into(slideImageView)
     //   slideImageView.setImageResource(slide_images[position])
        slideHeading.text = slide_headings[position]
        slideDescription.text = slide_descs[position]

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }



}