package com.example.data

import com.example.domain.MovieEntity
import com.example.domain.MoviesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesDataRepository @Inject constructor(private val restApi: RestApi
): MoviesRepository {

    override suspend fun searchMovies(keyWord: String): List<MovieEntity> {
        return restApi.searchMovies(keyWord, API_KEY).moviesList
    }
}