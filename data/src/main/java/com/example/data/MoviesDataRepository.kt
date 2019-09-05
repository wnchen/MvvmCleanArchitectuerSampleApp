package com.example.data

import com.example.data.CacheManager.Companion.KEY_MOVIE_LIST
import com.example.domain.MovieEntity
import com.example.domain.MoviesRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.logging.Level
import java.util.logging.Logger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesDataRepository @Inject constructor(private val restApi: RestApi,
                                               private val cacheManager: CacheManager,
                                               private val gson: Gson): MoviesRepository {

    private var movieEntityList: String? = null

    override suspend fun searchMovies(keyWord: String): List<MovieEntity> {
        return if (isCached()) retrieveCache() else cloud(keyWord)
    }

    private suspend fun retrieveCache(): List<MovieEntity> {
        return withContext(Dispatchers.IO) {
            Logger.getAnonymousLogger().log(Level.INFO, "read from cache in thread ${Thread.currentThread().name}")
            val movieListStr = movieEntityList ?: cacheManager.get(KEY_MOVIE_LIST)!!
            gson.fromJson(movieListStr) as List<MovieEntity>
        }
    }

    private suspend fun isCached(): Boolean {
        return withContext(Dispatchers.IO) {
            movieEntityList != null || cacheManager.get(KEY_MOVIE_LIST) != null
        }
    }

    private suspend fun cloud(keyWord: String): List<MovieEntity> {
        Logger.getAnonymousLogger().log(Level.INFO, "data repository in thread ${Thread.currentThread().name}")
        val movieList = restApi.searchMovies(keyWord, API_KEY).moviesList
        cacheManager.put(KEY_MOVIE_LIST, gson.toJson(movieList))
        return movieList
    }

    private inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)
}