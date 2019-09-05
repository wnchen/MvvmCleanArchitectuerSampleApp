package com.example.domain

import java.util.logging.Level
import java.util.logging.Logger
import javax.inject.Inject

class SearchMovieUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {

    suspend fun searchMovies(keyWord: String): List<MovieEntity> {
        Logger.getAnonymousLogger().log(Level.INFO, "lifecycletest searchMovies called")
        println("use case in thread ${Thread.currentThread().name}")
        return moviesRepository.searchMovies(keyWord)
    }
}
