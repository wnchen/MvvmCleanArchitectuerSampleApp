package com.example.mvvmcleanarchitectuersampleapp.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.MovieEntity
import kotlinx.android.synthetic.main.movie_item_view.view.*

class MovieEntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvId = itemView.tv_id
    val tvName = itemView.tv_name

    fun bind(movieEntity: MovieEntity) {
        tvId.text = movieEntity.id.toString()
        tvName.text = movieEntity.name
    }

}
