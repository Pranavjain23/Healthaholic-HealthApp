package com.example.healthapp.fragments

import android.os.Bundle
import android.text.Html
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
        val view = inflater.inflate(R.layout.fragment_app_creator, container, false)

        val link = view.findViewById<TextView>(R.id.txtMyId)
        link.text = Html.fromHtml("<a href=\"mailto:bhoomika.garg.9@gmail.com\">bhoomika.garg.9@gmail.com</a>")
        link.movementMethod = LinkMovementMethod.getInstance()

        val feedback = view.findViewById<TextView>(R.id.feedback)
        feedback.movementMethod = LinkMovementMethod.getInstance()



        val link1 = view.findViewById<TextView>(R.id.txtMyId1)
        link1.text = Html.fromHtml("<a href=\"mailto:ipranavjain@gmail.com\">ipranavjain@gmail.com</a>")
        link1.movementMethod = LinkMovementMethod.getInstance()

        val feedback1 = view.findViewById<TextView>(R.id.feedbackPranav)
        feedback1.movementMethod = LinkMovementMethod.getInstance()

        return view
    }
    private fun getActionBar(): androidx.appcompat.app.ActionBar? {
        return (activity as MainActivity).supportActionBar
    }
}