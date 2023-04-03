package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomerAdapter (private val listrepo: List<Repo>) : RecyclerView.Adapter<CustomerAdapter.ViewHolder>(){

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameRepoTextView = itemView.findViewById<TextView>(R.id.textlist)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel = listrepo[position]
        holder.nameRepoTextView.text = itemViewModel.name
    }
    override fun getItemCount(): Int {
        return listrepo.size
    }
}