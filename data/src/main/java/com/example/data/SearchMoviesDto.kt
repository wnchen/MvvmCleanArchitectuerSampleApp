package com.example.data

import com.example.domain.MovieEntity
import com.google.gson.annotations.SerializedName

data class SearchMoviesDto(@SerializedName("results") val moviesList: List<MovieEntity>)
