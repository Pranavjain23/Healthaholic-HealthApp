package com.example.healthapp.fragments

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.healthapp.R
import com.example.healthapp.activity.MainActivity

class AppCreatorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_app_creator, container, false)
       // getActionBar()?.setTitle("App Creator Team");


        val link = view.findViewById<TextView>(R.id.txtContactNumber)
        link.movementMethod = LinkMovementMethod.getInstance()
        val link10 = view.findViewById<TextView>(R.id.txtContactNumber1)
        link10.movementMethod = LinkMovementMethod.getInstance()

        return view
    }
    private fun getActionBar(): androidx.appcompat.app.ActionBar? {
        return (activity as MainActivity).supportActionBar
    }
}