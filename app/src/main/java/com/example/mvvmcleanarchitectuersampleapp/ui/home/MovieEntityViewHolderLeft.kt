package com.example.mvvmcleanarchitectuersampleapp.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.MovieEntity
import kotlinx.android.synthetic.main.movie_item_view.view.*

class MovieEntityViewHolderLeft(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvId = itemView.tv_id
    private val tvName = itemView.tv_name

    fun bind(
        movieEntity: MovieEntity,
        listener: MovieListAdapter.MovieListClickListener
    ) {
        tvId.text = movieEntity.id.toString()
        tvName.text = movieEntity.name
        itemView.setOnClickListener { listener.onItemClicked(movieEntity) }
    }

}