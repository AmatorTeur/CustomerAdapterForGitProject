package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomerAdapter (private val listrepoz: List<Repo>, private val clickPoItem: onItemClickListner) : RecyclerView.Adapter<CustomerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
    }
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val textView: TextView = itemView.findViewById(R.id.textlist)
    }

    interface onItemClickListner {
        fun onItemClick(view: View, position: Int): RecyclerView.OnItemTouchListener
    }
}