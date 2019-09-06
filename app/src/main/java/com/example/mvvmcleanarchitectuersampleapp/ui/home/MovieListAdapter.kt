package com.example.mvvmcleanarchitectuersampleapp.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.MovieEntity
import com.example.mvvmcleanarchitectuersampleapp.R

class MovieListAdapter(private val context: Context, private var movieList: List<MovieEntity>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val vh: RecyclerView.ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_view, parent, false)
        return MovieEntityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movieEntity = movieList[position]
        (holder as MovieEntityViewHolder).bind(movieEntity)
    }

    fun updateMovieListItems(updateMovieList: List<MovieEntity>?) {
        val diffCallback = MovieListDiffCallback(movieList, updateMovieList ?: listOf())
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        movieList = updateMovieList ?: listOf()
        diffResult.dispatchUpdatesTo(this)
    }

}
