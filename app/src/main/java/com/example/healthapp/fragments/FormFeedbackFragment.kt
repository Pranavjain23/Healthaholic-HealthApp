package com.example.healthapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.healthapp.R
import com.example.healthapp.model.DataFirebase
import com.google.firebase.database.*

class FormFeedbackFragment : Fragment() {

    lateinit var userName:EditText
    lateinit var userAge:EditText
    lateinit var userMail:EditText
    lateinit var userPhone:EditText
    lateinit var userQuery:EditText
    lateinit var rg:RadioGroup
    lateinit var radio1:RadioButton
    lateinit var radio2:RadioButton
    lateinit var radio3:RadioButton
    lateinit var submit:Button
    lateinit  var ref: DatabaseReference
    var maxid = 0
    private lateinit var member: DataFirebase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_form_feedback, container, false)
        userName=view.findViewById(R.id.userName)
        userAge=view.findViewById(R.id.userAge)
        userMail=view.findViewById(R.id.userEmail)
        userPhone=view.findViewById(R.id.userPhone)
        userQuery=view.findViewById(R.id.userQuery)
        userName=view.findViewById(R.id.userName)
        rg=view.findViewById(R.id.rg)
        radio1=view.findViewById(R.id.userMale)
        radio2=view.findViewById(R.id.userFemale)
        radio3=view.findViewById(R.id.userOthers)
         submit=view.findViewById(R.id.btnUserSubmit)

        member=DataFirebase()
        ref = FirebaseDatabase.getInstance().reference.child("User")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    maxid = snapshot.childrenCount.toInt()
                } else {
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
        submit.setOnClickListener(View.OnClickListener {
            member.setName(userName.text.toString())
            member.setEmail(userMail.text.toString())
            member.setPhone(userPhone.text.toString())
            member.setAge(userAge.text.toString() )
            member.setQuery(userQuery.text.toString() )
            val selectedOption: Int = rg.checkedRadioButtonId
            val rb: RadioButton = view.findViewById<RadioButton>(selectedOption)
            if(rb.text.equals("Male")){
                member.setGender("Male")
            }else if(rb.text.equals("Female")){
                member.setGender("Female")
            }else{
                member.setGender("Others")
            }

            ref.child((maxid + 1).toString()).setValue(member)
        })


        return view
    }

}