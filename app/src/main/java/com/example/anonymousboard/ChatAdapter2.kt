package com.example.anonymousboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anonymousboard.model.Order

class ChatAdapter2:RecyclerView.Adapter<ChatAdapter2.ChatViewHolder>() {
    fun interface OnItemClickListener{
        fun onItemClick(v:View,textViewPostId:String)
    }
    private var listener:OnItemClickListener? = null

    private var data:MutableList<Order> = mutableListOf()
    private lateinit var latitude:String
    private lateinit var longitude:String

    fun setListener(listener: OnItemClickListener){
        this.listener = listener
    }
    fun setData(data: MutableList<Order>){
        this.data = data
        notifyDataSetChanged()
    }
//    fun setLocation(){
//        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
//        val location : Location? = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
//
//        if (location != null) {
//            val latitude = location.latitude
//            val longitude = location.longitude
//            Log.d("Test", "GPS Location changed, Latitude: $latitude" +
//                    ", Longitude: $longitude")
//        }
//    }

    class ChatViewHolder(view: View, listener: OnItemClickListener?): RecyclerView.ViewHolder(view){
        val textViewStartPlace: TextView = view.findViewById(R.id.textViewStartPlace)
        val textViewStartTime: TextView = view.findViewById(R.id.textViewStartTime)
        val textViewEndTime: TextView = view.findViewById(R.id.textViewEndTime)
        val textViewEndPlace: TextView = view.findViewById(R.id.textViewEndPlace)
        val textViewDistance: TextView = view.findViewById(R.id.textViewDistance)
        val textViewDistanceFromMe: TextView = view.findViewById(R.id.textViewDistanceFromMe)
        val textViewSize: TextView = view.findViewById(R.id.textViewSize)
        val textViewWeight: TextView = view.findViewById(R.id.textViewWeight)
        val textViewPrice: TextView = view.findViewById(R.id.textViewPrice)
        val textView12: TextView = view.findViewById(R.id.textView12)
        val textViewOrdId: TextView = view.findViewById(R.id.textViewOrdId)
        init {
            view.setOnClickListener {
                listener?.onItemClick(view,textViewOrdId.text.toString())
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
        holder.textViewStartPlace.text = item.start_place
        holder.textViewStartTime.text = item.start_time
        holder.textViewEndTime.text = item.end_time
        holder.textViewEndPlace.text = item.end_place
        holder.textViewDistance.text = item.distance
        holder.textViewDistanceFromMe.text = item.distance_from_me
        holder.textViewSize.text = item.size
        holder.textViewWeight.text = item.weight
        holder.textViewPrice.text = item.price
        holder.textView12.text = "<->"
        holder.textViewOrdId.text = item.ord_id

    }

    override fun getItemCount(): Int {
        return data.size
    }
}