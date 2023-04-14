package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


open class CustomAdapter (private val listRepo: List<Repo>, private val listItemClick: OnItemClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel = listRepo[position]
        holder.nameRepoTextView.text = itemViewModel.name
//        holder.itemView.setOnClickListener {listItemClick}
    }

    override fun getItemCount(): Int {
        return listRepo.size
    }

    fun interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val nameRepoTextView = itemView.findViewById<TextView>(R.id.textlist)!!

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val position = adapterPosition
            listItemClick.onItemClick(v, position)
        }
    }

}