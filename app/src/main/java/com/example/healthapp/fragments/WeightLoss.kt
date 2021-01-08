package com.example.healthapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthapp.Adapter.DietPlanAdapter
import com.example.healthapp.R
import com.example.healthapp.model.Diet_plan_model


class WeightLoss : Fragment() {

    lateinit var recycler: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    lateinit var recyclerAdapter: DietPlanAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_weight_loss, container, false)
        recycler=view.findViewById(R.id.lossRecycler)
        layoutManager = LinearLayoutManager(activity)
        val lossArrayList= arrayListOf<Diet_plan_model>()

       lossArrayList.add(
            Diet_plan_model("⚫ Early morning ","Between 6 am to 7 am ","1 glass warm water with some herb brewed in it +2-3 soaked almonds ","a cup of milk without sugar")
        )
        lossArrayList.add(
            Diet_plan_model("⚫ Morning","Between 7:30 am to 8 am "," Lemon tea/ Ginger Tea/Coffee "," milk 1 cup (150 ml)")
        )
        lossArrayList.add(
            Diet_plan_model("Breakfast","Between 8:30 am to 9:30 am","Eggs omelette with spinach and shredded vegetables cooked ","Idlis / dosa/ Poha/ upma 1 cup cooked")
        )
        lossArrayList.add(
            Diet_plan_model("Lunch","Between 1 pm to 2 pm ","Salad with fresh vegetables and curd 1 cup ,Cooked vegetables/ greens(150gm),Phulkas ( multigrain ) 1 piece ,Rice ½ cup ","A sandwich with a cup of vegetables and some proteins like chicken,mushroom,soya,fish etc ")
        )
        lossArrayList.add(
            Diet_plan_model("Evening","Between 4 pm to 5 pm","Fruit/ sprouts/ cucumber –carrot slices/ vegetable soup ","Tea with 1/2 cup of snacks(nuts)")
        )
        lossArrayList.add(
            Diet_plan_model("Dinner","Between 7 pm to 8 pm","salad with fresh vegetables 1 cup ,Methi Dal / sambar/rasam (1 cup) ,Phulkas 1-2 piece ,Cooked vegetables(150 gms)","2 stuffed roti(any varities)")
        )
        lossArrayList.add(
            Diet_plan_model("Post dinner(Bedtime)","Between 9 pm to 10 pm","Milk (try to avoid)",    "Buttermilk (try to avoid) 150 ml")
        )

        recyclerAdapter = DietPlanAdapter(activity as Context, lossArrayList)

        recycler.adapter = recyclerAdapter
        recycler.layoutManager = layoutManager
        return view
    }

}

