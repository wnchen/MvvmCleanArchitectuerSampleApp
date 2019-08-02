package com.example.mvvmcleanarchitectuersampleapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ModuleViewModel {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchMovieViewModel::class)
    abstract fun passwordPolicyViewModel(searchMovieViewModel: SearchMovieViewModel): ViewModel
}
