package com.example.data

import com.example.domain.MoviesRepository
import dagger.Binds
import dagger.Module

@Module
abstract class ModuleDataRepository {

    @Binds
    abstract fun bindMoviesRepository(moviesDataRepository: MoviesDataRepository): MoviesRepository
}