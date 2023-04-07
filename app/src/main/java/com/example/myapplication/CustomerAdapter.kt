package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


open class CustomerAdapter (private val listrepo: List<Repo>, private val listItemClick: OnItemClickListener) : RecyclerView.Adapter<CustomerAdapter.ViewHolder>(){

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val nameRepoTextView = itemView.findViewById<TextView>(R.id.textlist)!!

        init {
            itemView.setOnClickListener(this@ViewHolder)
        }
        override fun onClick(v: View) {
            val position = adapterPosition
            listItemClick.onItemClick(v, position)
        }
    }

    fun interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
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
//        holder.itemView.setOnClickListener {listItemClick}
    }
    override fun getItemCount(): Int {
        return listrepo.size
    }
}
