package com.example.mvvmcleanarchitectuersampleapp.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.MovieEntity
import kotlinx.android.synthetic.main.movie_item_view.view.*

class MovieEntityViewHolderRight(private val _itemView: View) : RecyclerView.ViewHolder(_itemView) {
    private val tvId = _itemView.tv_id
    private val tvName = _itemView.tv_name

    fun bind(
        movieEntity: MovieEntity,
        listener: MovieListAdapter.MovieListClickListener
    ) {
        tvName.text = movieEntity.id.toString()
        tvId.text = movieEntity.name
        _itemView.setOnClickListener { listener.onItemClicked(movieEntity) }
    }

}
