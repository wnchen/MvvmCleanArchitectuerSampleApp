package com.example.data

import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET(SEARCH_MOVIES)
    suspend fun searchMovies(@Query("query") query: String, @Query("api_key") apiKey: String): SearchMoviesDto
}

const val SEARCH_MOVIES = "search/company"
const val API_KEY = "2aa95be1c57a8645756260191716244f"



