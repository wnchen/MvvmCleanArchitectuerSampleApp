package com.example.mvvmcleanarchitectuersampleapp.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.MovieEntity

class MovieListDiffCallback(private val oldMovieList: List<MovieEntity>, private val newMovieList: List<MovieEntity>):
    DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldMovieList[oldItemPosition].id == newMovieList[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldMovieList.size
    }

    override fun getNewListSize(): Int {
        return newMovieList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldMovieList[oldItemPosition].name == newMovieList[newItemPosition].name
    }
}