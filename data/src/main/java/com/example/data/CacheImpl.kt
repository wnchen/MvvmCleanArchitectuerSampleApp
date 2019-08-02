package com.example.data

import android.content.SharedPreferences
import javax.inject.Inject

class CacheImpl @Inject constructor(private val sharedPreferences: SharedPreferences): CacheInterface {
    override fun put(key: String, value: String) {
        val editor = sharedPreferences.edit();
        editor.putString(key, value)
        editor.apply()
    }

    override fun get(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    override fun update(key: String, value: String) {
        put(key, value)
    }

    override fun delete(key: String) {
        val editor = sharedPreferences.edit();
        editor.remove(key)
        editor.apply()
    }
}