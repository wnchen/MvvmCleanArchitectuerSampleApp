package com.example.data

interface CacheInterface {
    fun put(key: String, value: String)
    fun get(key: String): String?
    fun update(key: String, value: String)
    fun delete(key: String)
}
