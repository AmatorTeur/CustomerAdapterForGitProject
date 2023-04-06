package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomerAdapter (private val listrepo: List<Repo>, private val listItemClick: OnItemClickListener) : RecyclerView.Adapter<CustomerAdapter.ViewHolder>(){

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

    interface OnItemClickListener {
        companion object{
        }
        fun onItemClick(view: View, position: Int): RecyclerView.OnItemTouchListener
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

//class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
//{
//
//    fun bind(repo: Repo, clickListener: OnItemClickListener)
//    {
//
//        itemView.setOnClickListener {
//            clickListener.onItemClicked(repo)
//        }
//    }
//
//}
//
//
//class CustomerAdapter(var repos: List<Repo>, val itemClickListener: OnItemClickListener):RecyclerView.Adapter<MyHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main,parent,false)
//        return MyHolder(view)
//
//
//    }
//
//    override fun getItemCount(): Int {
//        return repos.size
//    }
//
//    override fun onBindViewHolder(myHolder: MyHolder, position: Int) {
//        val repo = repos[position]
//        myHolder.bind(repo,itemClickListener)
//
//
//    }
//}
//
//
//interface OnItemClickListener{
//    fun onItemClicked(repo: Repo)
//}