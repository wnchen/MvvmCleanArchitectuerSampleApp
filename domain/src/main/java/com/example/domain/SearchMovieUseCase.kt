package com.example.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.logging.Level
import java.util.logging.Logger
import javax.inject.Inject

class SearchMovieUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {

    suspend fun searchMovies(keyWord: String): List<MovieEntity> {
        return withContext(Dispatchers.IO) {
            Logger.getAnonymousLogger().log(Level.INFO, "lifecycletest searchMovies called")
            Logger.getAnonymousLogger().log(Level.INFO, "use case in thread ${Thread.currentThread().name}")
            moviesRepository.searchMovies(keyWord)
        }
    }
}
