package com.example.reviewumc

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerVPAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {

    private val fragmentlist : ArrayList<Fragment> = ArrayList() //VP에 들어갈 fragment 여러 개
    override fun getItemCount(): Int = fragmentlist.size

    override fun createFragment(position: Int): Fragment = fragmentlist[position]
    fun addFragment(fragment: Fragment) {
        fragmentlist.add(fragment)
        notifyItemInserted(fragmentlist.size - 1)
    }


}