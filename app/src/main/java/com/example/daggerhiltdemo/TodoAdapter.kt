package com.example.daggerhiltdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
    private var data: List<Todo>? = null

    fun setData(data: List<Todo>?) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = data?.get(position)
        holder.titleTextView.text = todo?.title
        holder.bodyTextView.text = todo?.id.toString()
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val bodyTextView: TextView = itemView.findViewById(R.id.idTextView)
    }
}
