package com.example.mvvmcleanarchitectuersampleapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.MovieEntity
import com.example.domain.SearchMovieUseCase
import kotlinx.coroutines.launch
import java.util.logging.Level
import java.util.logging.Logger
import javax.inject.Inject

internal class SearchMovieViewModel @Inject constructor(private val searchMovieUseCase: SearchMovieUseCase): ViewModel() {

    private val searchMovieListLiveData: MutableLiveData<List<MovieEntity>> by lazy {
        MutableLiveData<List<MovieEntity>>()
    }

    fun searchMovieList(keyWord: String) {
        viewModelScope.launch {
            Logger.getAnonymousLogger().log(Level.INFO, "launch viewmodelscope in thread ${Thread.currentThread().name}")
            searchMovieListLiveData.postValue(searchMovieUseCase.searchMovies(keyWord))
        }
    }

    fun observeToMovieListChange(): LiveData<List<MovieEntity>> {
        return searchMovieListLiveData
    }
}
