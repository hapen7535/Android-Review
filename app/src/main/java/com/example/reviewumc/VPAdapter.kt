package com.example.reviewumc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VPAdapter(strData: ArrayList<String>, colorData: ArrayList<Int>)
    : RecyclerView.Adapter<VPAdapter.MyViewHolder>() {

    val arrData = strData
    val arrColors = colorData

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtCount: TextView = itemView.findViewById(R.id.txtCount)
        var bgColor : LinearLayout = itemView.findViewById(R.id.background)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.view_pager_item, parent, false)
        val viewHolder = MyViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtCount.text = arrData[position]
        holder.bgColor.setBackgroundColor(arrColors[position])
    }

    override fun getItemCount(): Int {
        return arrData.size
    }

}