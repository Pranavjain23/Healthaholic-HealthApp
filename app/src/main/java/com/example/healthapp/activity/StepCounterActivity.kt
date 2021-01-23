package com.example.healthapp.activity

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.healthapp.R
import com.example.healthapp.fragments.PhysicalFragment
import kotlinx.android.synthetic.main.step_counter_activity.*

class StepCounterActivity  : AppCompatActivity(), SensorEventListener {

    private var sensorManager : SensorManager? = null
    private lateinit var calories: TextView
    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f
    lateinit var backArrow : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step_counter_activity)
        calories=findViewById(R.id.calories_burnt)
        backArrow=findViewById(R.id.backArrow)
        backArrow.setOnClickListener {

        }
        loadData()
        resetSteps()
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager


    }

    override fun onResume() {
        super.onResume()
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

}