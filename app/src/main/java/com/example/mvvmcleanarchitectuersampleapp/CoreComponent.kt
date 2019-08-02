package com.example.mvvmcleanarchitectuersampleapp

import com.example.data.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleAppContext::class, ModuleViewModel::class,
ModuleDataRepository::class, ModuleRetrofit::class,
ModuleSharedPreference::class, ModuleCache::class,
ModuleGson::class])
interface CoreComponent {
    fun viewModelFactory(): ViewModelFactory
}
