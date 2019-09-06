package com.example.mvvmcleanarchitectuersampleapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.MovieEntity
import com.example.mvvmcleanarchitectuersampleapp.R

class MovieListAdapter(private var movieList: List<MovieEntity>, private val listener: MovieListClickListener):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface MovieListClickListener {
        fun onItemClicked(movieEntity: MovieEntity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_view, parent, false)
        return if (viewType == ITEM_VIEW_TYPE_LEFT) MovieEntityViewHolderLeft(view) else MovieEntityViewHolderRight(view)
    }

    override fun getItemViewType(position: Int): Int =
        if (position % 2 == 0) ITEM_VIEW_TYPE_LEFT else ITEM_VIEW_TYPE_RIGHT

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movieEntity = movieList[position]
        when(holder) {
            is MovieEntityViewHolderLeft -> holder.bind(movieEntity, listener)
            is MovieEntityViewHolderRight -> holder.bind(movieEntity, listener)
        }
    }

    fun updateMovieListItems(updateMovieList: List<MovieEntity>?) {
        val diffCallback = MovieListDiffCallback(movieList, updateMovieList ?: listOf())
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        movieList = updateMovieList ?: listOf()
        diffResult.dispatchUpdatesTo(this)
    }

    companion object {
        const val ITEM_VIEW_TYPE_LEFT = 0
        const val ITEM_VIEW_TYPE_RIGHT = 1
    }
}
