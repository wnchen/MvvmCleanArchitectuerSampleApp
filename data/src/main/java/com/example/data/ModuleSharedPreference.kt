package com.example.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleSharedPreference {

    @Provides
    @Singleton
    fun provideSharedPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHAREPREF_NAME, MODE_PRIVATE)
    }

    companion object {
        private const val SHAREPREF_NAME = "share_pref"
    }
}