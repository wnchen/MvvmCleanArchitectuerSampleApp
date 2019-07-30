package com.example.mvvmcleanarchitectuersampleapp

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleAppContext(private val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app.applicationContext
    }
}
