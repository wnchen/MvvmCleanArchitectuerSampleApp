package com.example.data

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleGson {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }
}