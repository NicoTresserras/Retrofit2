package com.example.retrofit2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ApodAdapter(private val apodList: List<ApodResponse>) : RecyclerView.Adapter<ApodAdapter.ApodViewHolder>() {

    class ApodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val explanation: TextView = view.findViewById(R.id.explanation)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_apod, parent, false)
        return ApodViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApodViewHolder, position: Int) {
        val apod = apodList[position]

        holder.title.text = apod.title
        holder.explanation.text = apod.explanation

       if (apod.media_type == "image") {
            Glide.with(holder.imageView.context)
                .load(apod.url)
                .into(holder.imageView)
        }
    }

    override fun getItemCount(): Int {
        return apodList.size
    }
}
