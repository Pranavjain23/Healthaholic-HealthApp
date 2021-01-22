package com.example.healthapp.fragments

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.healthapp.R
import com.example.healthapp.activity.MainActivity
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
    var selectedOption: Int =0
    var maxid = 0
    lateinit var rb: RadioButton

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
        radio1.isChecked = true
        rb=view.findViewById(R.id.userMale)
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
//           if(userPhone.text.toString().length!=10){
//                Toast.makeText(context,"Incorrect mobile number",Toast.LENGTH_SHORT).show()
//            }
             if(checkIsEmpty(userName.text.toString(),userMail.text.toString(),userPhone.text.toString(),userAge.text.toString(),userQuery.text.toString() )){
            member.setName(userName.text.toString())
            member.setEmail(userMail.text.toString())
            member.setPhone(userPhone.text.toString())
            member.setAge(userAge.text.toString() )
            member.setQuery(userQuery.text.toString())
            selectedOption=rg.checkedRadioButtonId
            rb = view.findViewById(selectedOption)
            if(rb.text.equals("Male")){
                member.setGender("Male")
            }else if(rb.text.equals("Female")){
                member.setGender("Female")
            }else{
                member.setGender("Others")
            }

            ref.child((maxid + 1).toString()).setValue(member)
            val dialog = AlertDialog.Builder(activity as Context)
            dialog.setTitle("Thankyou!")
            dialog.setMessage("Your feedback is valuable to us. Our team will reach you out at "+userMail.text.toString())
            dialog.setPositiveButton("OKAY"){ text,listener ->
                val fragment = HomeFragment()
                val args = Bundle()
                fragment.arguments = args
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.frame,
                        fragment
                    ).commit()
            }

            dialog.setNegativeButton(""){ text, listener ->
            }
            dialog.create()
            dialog.show()

            }else{
                Toast.makeText(context,"Information incomplete!!",Toast.LENGTH_LONG).show()
            }
        })

        return view
    }

    fun checkIsEmpty(name:String,mail:String,phone:String,age:String,query:String):Boolean{
            if(name == "" ||phone.equals("")||age.equals("")||mail.equals("")||query.equals("")){
                return false
            }
        return true

    }

}