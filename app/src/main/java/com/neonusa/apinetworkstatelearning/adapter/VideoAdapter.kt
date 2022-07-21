package com.neonusa.apinetworkstatelearning.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.neonusa.apinetworkstatelearning.R
import com.neonusa.apinetworkstatelearning.model.YoutubeData
import com.squareup.picasso.Picasso

class VideoAdapter(private val listVideo: List<YoutubeData>): RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    class VideoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        var tvDes: TextView = itemView.findViewById(R.id.textViewDes)
        var tvDate: TextView = itemView.findViewById(R.id.textViewDate)
        var img: ImageView = itemView.findViewById(R.id.img_thumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val title = listVideo[position].snippet.title
        val desc = listVideo[position].snippet.description
        val date = listVideo[position].snippet.publishedAt
        val imgUrl = listVideo[position].snippet.thumbnails.medium.url

        holder.tvTitle.text = title
        holder.tvDes.text = desc
        holder.tvDate.text = date

        Picasso.with(holder.itemView.context).load(imgUrl).into(holder.img)

    }

    override fun getItemCount(): Int = listVideo.size

}