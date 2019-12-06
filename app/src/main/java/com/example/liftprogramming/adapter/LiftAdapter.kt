package com.example.liftprogramming.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.liftprogramming.R
import com.example.liftprogramming.model.LiftModel

class LiftAdapter(val liftList: ArrayList<LiftModel>) :
    RecyclerView.Adapter<LiftAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiftAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_recycle, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {


        return liftList.size
    }

    override fun onBindViewHolder(holder: LiftAdapter.ViewHolder, position: Int) {


        holder.bindItems(liftList[position])
    }


    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(lift: LiftModel) {
            val textLiftUp = itemView.findViewById(R.id.textViewUp) as TextView
            val textLiftDown = itemView.findViewById(R.id.textViewDown) as TextView
            val imageLift = itemView.findViewById(R.id.imageView) as ImageView
            textLiftUp.text = lift.liftUp
            textLiftDown.text = lift.liftDown
        }
    }
}