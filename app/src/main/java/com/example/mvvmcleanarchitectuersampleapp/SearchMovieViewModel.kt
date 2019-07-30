package com.example.mvvmcleanarchitectuersampleapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.MovieEntity
import com.example.domain.SearchMovieUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchMovieViewModel @Inject constructor(private val searchMovieUseCase: SearchMovieUseCase): ViewModel() {

    private val searchMovieListLiveData: MutableLiveData<List<MovieEntity>> by lazy {
        MutableLiveData<List<MovieEntity>>()
    }

    fun searchMovieList(keyWord: String) {
        viewModelScope.launch {
            Log.i("lifecycletest", "coroutine called")
            searchMovieListLiveData.postValue(searchMovieUseCase.searchMovies(keyWord))
            Log.i("lifecycletest", "coroutine end")
        }
        Log.i("lifecycletest", "coroutine return")
    }

    override fun onCleared() {
        Log.i("lifecycletest", "onCleared called")
        super.onCleared()
    }

    fun observeToMovieListChange(): LiveData<List<MovieEntity>> {
        return searchMovieListLiveData
    }
}
