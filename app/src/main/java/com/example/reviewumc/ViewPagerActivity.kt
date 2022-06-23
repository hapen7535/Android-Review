package com.example.reviewumc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class ViewPagerActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        var arrStr: ArrayList<String> = ArrayList()
        for (i in 1..100) {
            arrStr.add(i.toString())
        }
        var arrColorsString = arrayListOf<String>("#FF0000","#FF5E00", "#FFBB00", "#FFE400", "#0054FF")
        var arrIntColor = ArrayList<Int>()
        for (i in 1..100){
            arrIntColor.add(Color.parseColor(arrColorsString[i%5]))
        }


        var adapter = VPAdapter(arrStr, arrIntColor)

        viewPager2 = findViewById(R.id.viewpager2)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager2.adapter = adapter

    }

}