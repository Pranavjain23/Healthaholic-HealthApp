package com.example.healthapp.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.healthapp.R
import com.example.healthapp.activity.StepCounterActivity
import com.example.healthapp.activity.BmiActivity
import com.example.healthapp.activity.DevelopedByActivity
import com.example.healthapp.activity.MainActivity

class HomeFragment : Fragment() {

    lateinit var btnStepcounter : CardView
    lateinit var btnBMI : CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)



        btnStepcounter = view.findViewById(R.id.btnStepCounter)
        btnBMI = view.findViewById(R.id.btnBMI)

        btnStepcounter.setOnClickListener {
            val intent = Intent(context, StepCounterActivity::class.java)
            startActivity(intent)
        }
        btnBMI.setOnClickListener {
            val intent = Intent(context, BmiActivity::class.java)
           startActivity(intent)
        }
        return view
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_information,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.info){
            val intent = Intent(context, DevelopedByActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}