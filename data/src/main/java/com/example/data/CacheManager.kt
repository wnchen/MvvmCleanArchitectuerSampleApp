package com.example.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CacheManager @Inject constructor(private val cacheInterface: CacheInterface) {

    companion object {
        const val KEY_MOVIE_LIST = "key_movie_list"
    }

    fun put(key: String, value: String) {
        cacheInterface.put(key, value)
    }

    fun get(key: String): String? {
        return cacheInterface.get(key)
    }

    fun update(key: String, value: String) {
        cacheInterface.update(key, value)
    }

    fun delete(key: String) {
        cacheInterface.delete(key)
    }
}