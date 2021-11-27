package com.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.Pojo.Drug
import android.content.Context

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.drugsdz.R


class Drugs_Adapter(val context: Context) : RecyclerView.Adapter<Drugs_Adapter.DrugViewHolder>() {

    var array_drugs = arrayListOf<Drug>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrugViewHolder {
        return DrugViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_drug ,parent ,false))
    }

    var lastPosition = - 1
    override fun onBindViewHolder(holder: DrugViewHolder, position: Int) {
        holder.name.text = array_drugs[position].D_NM
        holder.name_international.text = array_drugs[position].D_N_I
        holder.dose.text = array_drugs[position].D_D
        holder.type.text = array_drugs[position].D_TYPE
        val animation: Animation = AnimationUtils.loadAnimation(
            context,
            if (position > lastPosition) R.anim.up_from_bottom else R.anim.down_from_top
        )
        holder.itemView.startAnimation(animation)
        lastPosition = position
    }

    override fun getItemCount(): Int {
        return array_drugs.size
    }

    class DrugViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tv_drug_name)
        val name_international = itemView.findViewById<TextView>(R.id.tv_drug_international_name)
        val dose = itemView.findViewById<TextView>(R.id.tv_drug_dose)
        val type = itemView.findViewById<TextView>(R.id.tv_drug_type)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(array:ArrayList<Drug>)
    {
        array_drugs = array
        notifyDataSetChanged()
    }

    override fun onViewDetachedFromWindow(holder: DrugViewHolder) {
        holder.itemView.clearAnimation()
        super.onViewDetachedFromWindow(holder)
    }

}