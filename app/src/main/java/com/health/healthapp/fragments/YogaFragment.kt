package com.health.healthapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.health.healthapp.R
import com.health.healthapp.activity.YogaActivity


class YogaFragment : Fragment() {

    lateinit var btnYoga : Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_yoga, container, false)

        btnYoga = view.findViewById(R.id.btnYoga)

        btnYoga.setOnClickListener{
            val intent = Intent(context, YogaActivity::class.java)
            startActivity(intent)
        }

        return view
    }

}


