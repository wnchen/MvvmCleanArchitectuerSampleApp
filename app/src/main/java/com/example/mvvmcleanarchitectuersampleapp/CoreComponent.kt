package com.example.mvvmcleanarchitectuersampleapp

import com.example.data.ModuleDataRepository
import com.example.data.ModuleRetrofit
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleAppContext::class, ModuleViewModel::class,
ModuleDataRepository::class, ModuleRetrofit::class])
interface CoreComponent {
    fun viewModelFactory(): ViewModelFactory
}
