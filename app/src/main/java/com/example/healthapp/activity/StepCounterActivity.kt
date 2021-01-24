package com.example.healthapp.activity

import android.app.FragmentTransaction
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.healthapp.Adapter.SliderAdapter_excerciseAdv
import com.example.healthapp.R
import com.example.healthapp.fragments.HomeFragment
import com.example.healthapp.model.excerciseadv
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.step_counter_activity.*


class StepCounterActivity  : AppCompatActivity(), SensorEventListener {

    private var sensorManager : SensorManager? = null
    private lateinit var calories: TextView
    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f
    lateinit var backArrow : ImageView

    lateinit var viewPager2: ViewPager2
    lateinit var viewPager3: ViewPager2
    lateinit var viewPager4: ViewPager2
    lateinit var viewPager5: ViewPager2

    lateinit var sliderAdapter : SliderAdapter_excerciseAdv
    private val sliderHandler = Handler()


    val excerciseAdvList = arrayListOf<excerciseadv>()
    val excerciseAdvList2 = arrayListOf<excerciseadv>()
    val excerciseAdvList3 = arrayListOf<excerciseadv>()
    val excerciseAdvList4 = arrayListOf<excerciseadv>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step_counter_activity)
        calories=findViewById(R.id.calories_burnt)
        backArrow=findViewById(R.id.backArrow)
        backArrow.setOnClickListener {
            finish()
        }


        viewPager2 = findViewById(R.id.excerciseAdvViewPager)
        excerciseAdvList.add(excerciseadv("It helps you maintain a healthy weight."))
        excerciseAdvList.add(excerciseadv("It increases your heart health."))
        excerciseAdvList.add(excerciseadv("Improve your balance and coordination."))
        excerciseAdvList.add(excerciseadv("It's eases down your joints."))

        viewPager3 = findViewById(R.id.excerciseAdvViewPager2)
        excerciseAdvList2.add(excerciseadv("Running has the Power to Eliminate Depression."))
        excerciseAdvList2.add(excerciseadv("Running Boosts Your Confidence."))
        excerciseAdvList2.add(excerciseadv("Running is one of the best forms of exercise for losing or maintaining a consistent weight."))
        excerciseAdvList2.add(excerciseadv("It Improves Your Health"))

        viewPager4 = findViewById(R.id.excerciseAdvViewPager3)
        excerciseAdvList3.add(excerciseadv("Jogging improves Bone Strength"))
        excerciseAdvList3.add(excerciseadv("Keeps the Mind Healthy"))
        excerciseAdvList3.add(excerciseadv("Jogging Helps in Weight Loss"))
        excerciseAdvList3.add(excerciseadv("Good for the Heart"))

        viewPager5 = findViewById(R.id.excerciseAdvViewPager4)
        excerciseAdvList4.add(excerciseadv("Climbing stairs improves health. It releases more endorphins, which helps you feel good."))
        excerciseAdvList4.add(excerciseadv("It helps regulate your sleep pattern better."))
        excerciseAdvList4.add(excerciseadv("It Challenges Your Cardiovascular System."))
        excerciseAdvList4.add(excerciseadv("It Can Help Improve Coordination"))


        viewPager2.adapter = SliderAdapter_excerciseAdv(excerciseAdvList, viewPager2)
        viewPager3.adapter = SliderAdapter_excerciseAdv(excerciseAdvList2, viewPager3)
        viewPager4.adapter = SliderAdapter_excerciseAdv(excerciseAdvList3, viewPager4)
        viewPager5.adapter = SliderAdapter_excerciseAdv(excerciseAdvList4, viewPager5)



        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        viewPager3.clipToPadding = false
        viewPager3.clipChildren = false
        viewPager3.offscreenPageLimit = 3
        viewPager3.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        viewPager4.clipToPadding = false
        viewPager4.clipChildren = false
        viewPager4.offscreenPageLimit = 3
        viewPager4.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        viewPager5.clipToPadding = false
        viewPager5.clipChildren = false
        viewPager5.offscreenPageLimit = 3
        viewPager5.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.25f

        }
        viewPager2.setPageTransformer(compositePageTransformer)
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })

        viewPager3.setPageTransformer(compositePageTransformer)
        viewPager3.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })

        viewPager4.setPageTransformer(compositePageTransformer)
        viewPager4.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })

        viewPager5.setPageTransformer(compositePageTransformer)
        viewPager5.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })



        loadData()
        resetSteps()
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager


    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable,3000)
        running = true
        val stepSensor= sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if(stepSensor == null){
            Toast.makeText(this, "No Sensor detected on this device", Toast.LENGTH_SHORT).show()
        }else{
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {

        if (running){
            totalSteps = event!!.values[0]
            val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()
            tv_stepsTaken.text = ("$currentSteps")

            progress_circular.apply {
                setProgressWithAnimation(currentSteps.toFloat())
            }
            val cal:Int=caloriesBurnt_func(currentSteps).toInt()
            calories.text=cal.toString()
        }
    }

    private fun resetSteps(){
        tv_stepsTaken.setOnClickListener {
            Toast.makeText(this, "Long tap to restart steps", Toast.LENGTH_SHORT).show()
        }

        tv_stepsTaken.setOnLongClickListener{
            previousTotalSteps = totalSteps
            tv_stepsTaken.text = 0.toString()
            saveData()

            true
        }
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor  = sharedPreferences.edit()
        editor.putFloat("key1", previousTotalSteps)
        editor.apply()
    }

    private fun loadData(){
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences.getFloat("key1", 0f)
        Log.d("StepCounter", "$savedNumber")
        previousTotalSteps = savedNumber

    }

    fun caloriesBurnt_func(StepCounts: Int): Double {
        return 0.045 * StepCounts
    }

    private val sliderRunnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
        viewPager3.currentItem = viewPager3.currentItem + 1
        viewPager4.currentItem = viewPager4.currentItem + 1
        viewPager5.currentItem = viewPager5.currentItem + 1
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.postDelayed(sliderRunnable,3000)
    }


}