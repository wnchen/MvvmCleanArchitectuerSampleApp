package com.example.domain

interface MoviesRepository {
    suspend fun searchMovies(keyWord: String): List<MovieEntity>
}
