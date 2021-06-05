package com.tech.accionflicker.UI

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tech.accionflicker.R
import com.tech.accionflicker.data.Photo
import kotlinx.android.synthetic.main.photo.view.*

class FlickerSearchAdapter(val photos :MutableList<Photo> = mutableListOf()) :
    RecyclerView.Adapter<FlickerSearchAdapter.flickerViewHolder>() {
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): flickerViewHolder {
        context = parent.context
       return flickerViewHolder(
           LayoutInflater.from(parent.context).inflate(
               R.layout.photo,
               parent,
               false
           )
       )
    }

    override fun onBindViewHolder(holder: flickerViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int = photos.size



    inner class flickerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            fun bind(photo :Photo){
                val image = photos.get(adapterPosition)
                Glide.with(context!!)
                    .load(image.url)
                    .fitCenter()
                    .into(itemView.imageView)
            }
    }


}