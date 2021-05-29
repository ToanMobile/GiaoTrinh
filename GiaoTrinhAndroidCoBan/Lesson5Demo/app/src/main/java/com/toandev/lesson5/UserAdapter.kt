package com.toandev.lesson5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val list: List<UserModel>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_toan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemGioHang = list.get(position)
        holder.textViewName.text = itemGioHang.name
        holder.textViewAge.text = itemGioHang.age.toString()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.txtName)
        val textViewAge: TextView = view.findViewById(R.id.txtAge)
    }
}