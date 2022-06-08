package com.example.anonymousboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anonymousboard.model.Post

class ChatAdapter:RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    private var data:MutableList<Post> = mutableListOf()

    fun setData(data:MutableList<Post>){
        this.data = data
        notifyDataSetChanged()
    }

    class ChatViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewTitle: TextView = view.findViewById(R.id.textViewTitle)
        val textViewTime:TextView = view.findViewById(R.id.textViewTime)
        val textViewViews: TextView = view.findViewById(R.id.textViewViews)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.post_list,parent,false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val item = data[position]
        holder.textViewTitle.text = item.title
        holder.textViewTime.text = item.created_time
        holder.textViewViews.text = item.views

    }

    override fun getItemCount(): Int {
        return data.size
    }
}
