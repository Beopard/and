package com.example.anonymousboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anonymousboard.model.Post

class ChatAdapter:RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    fun interface OnItemClickListener{
        fun onItemClick(v:View,textViewPostId:String)
    }
    private var listener:OnItemClickListener? = null

    private var data:MutableList<Post> = mutableListOf()

    fun setListener(listener: OnItemClickListener){
        this.listener = listener
    }
    fun setData(data: MutableList<Post>){
        this.data = data
        notifyDataSetChanged()
    }

    class ChatViewHolder(view: View, listener: OnItemClickListener?): RecyclerView.ViewHolder(view){
        val textViewPostId: TextView = view.findViewById(R.id.textViewPostId)
        val textViewTitle: TextView = view.findViewById(R.id.textViewTitle)
        val textViewTime:TextView = view.findViewById(R.id.textViewTime)
        val textViewViews: TextView = view.findViewById(R.id.textViewViews)
        init {
            view.setOnClickListener {
                listener?.onItemClick(view,textViewPostId.text.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.post_list,parent,false)
        return ChatViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val item = data[position]
        holder.textViewPostId.text = item.post_id
        holder.textViewTitle.text = item.title
        holder.textViewTime.text = item.created_time
        holder.textViewViews.text = item.views

    }

    override fun getItemCount(): Int {
        return data.size
    }
}
