package com.health.healthapp.activity

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.health.healthapp.BuildConfig
import com.health.healthapp.R
import com.health.healthapp.fragments.*
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    lateinit var frameLayout:FrameLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var navigationView: NavigationView

    var previousMenuItem: MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        frameLayout = findViewById(R.id.frame)
        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navigationView)
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        setUpToolbar()


        openHome()

        drawerLayout.addDrawerListener(actionBarDrawerToggle)   //making work hamburger icon
        actionBarDrawerToggle.syncState()

        val csl = ColorStateList(
            arrayOf(
                intArrayOf(-android.R.attr.state_checked),
                intArrayOf(android.R.attr.state_checked)
            ), intArrayOf(
                Color.BLACK,
                Color.parseColor("#EF4872")
            )
        )
        navigationView.itemTextColor = csl
        navigationView.itemIconTintList = csl

        navigationView.setNavigationItemSelectedListener {

            if (previousMenuItem!=null){
                previousMenuItem?.isChecked = false
            }

            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            when(it.itemId) {
                R.id.homee -> {
                    supportFragmentManager.beginTransaction()
                    openHome()
                    drawerLayout.closeDrawers()

                }
                R.id.gymWorkout -> {
                    supportFragmentManager.beginTransaction()
                    openGym()
                    drawerLayout.closeDrawers()
                }
                R.id.yoga -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame,
                            YogaFragment()
                        )
                        .commit()
                    //      supportActionBar?.title = "Yoga Workout"
                    drawerLayout.closeDrawers()
                }
                R.id.dimensionOfWellness -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame,
                            DimensionOfWellnessFragment()
                        ).commit()
                    //     supportActionBar?.title = "Dimensions Of Wellness"
                    drawerLayout.closeDrawers()
                }
                R.id.homeWorkout -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame,
                            HomeWorkoutFragment()
                        ).commit()
                    //     supportActionBar?.title = "Home Workout"
                    drawerLayout.closeDrawers()
                }

                R.id.share -> {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(
                        Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID
                    )
                    startActivity(shareIntent)
                }
                R.id.aboutapp -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame,
                            AboutAppFragment()
                        )

                        .commit()

                    //    supportActionBar?.title = "About app"
                    drawerLayout.closeDrawers()
                }

                R.id.feedbackUser -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame,
                            FormFeedbackFragment()
                        )
                        .commit()

                    // supportActionBar?.title = (getString(R.string.languagetitle))
                    drawerLayout.closeDrawers()
                }

            }
            return@setNavigationItemSelectedListener true

        }

    }
    private fun setUpToolbar(){
        setSupportActionBar(toolbar)
     //   supportActionBar?.title = "Toolbar title"
   //     supportActionBar?.setDisplayShowTitleEnabled(false);
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        if(id==android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }


    private fun openHome(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.frame,
            HomeFragment()
        )
        transaction.commit()
   //     supportActionBar?.title = "Health And Wellness"
        previousMenuItem?.isChecked = false

        navigationView.setCheckedItem(R.id.homee)

    }
    private fun openGym(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.frame,
            GymFragment()
        )
        transaction.commit()
      //  supportActionBar?.title = "Gym Workout"
        previousMenuItem?.isChecked = false

        navigationView.setCheckedItem(R.id.gymWorkout)

    }

    private fun openDow(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.frame,
            DimensionOfWellnessFragment()
        )
        transaction.commit()
        //  supportActionBar?.title = "Gym Workout"
        previousMenuItem?.isChecked = false

        navigationView.setCheckedItem(R.id.dimensionOfWellness)

    }

    override fun onBackPressed() {

        when(supportFragmentManager.findFragmentById(R.id.frame)){
            is GymFragment -> openHome()
            is YogaFragment -> openHome()
            is AboutAppFragment -> openHome()
            is DimensionOfWellnessFragment -> openHome()
            is HomeWorkoutFragment -> openHome()
            is Gym_routine_advance -> openGym()
            is Gym_routine_beginner -> openGym()
            is Gym_routine_intermediate -> openGym()

            is MealMenuFragment ->  openHome()

            is WeightGain -> openHome()
            is WeightLoss -> openHome()
            is DietPlan -> openHome()
            is FormFeedbackFragment -> openHome()
            is PhysicalFragment -> openDow()
            is SocialFragment -> openDow()
            is SpiritualFragment -> openDow()
            is IntellectualFragment -> openDow()
            is EmotionalFragment -> openDow()

            is AppCreatorFragment -> openHome()

            else -> super.onBackPressed()
        }
    }

}