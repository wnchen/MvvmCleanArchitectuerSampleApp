package com.example.data

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ModuleCache {

    @Binds
    @Singleton
    abstract fun bindCacheInterface(cacheImpl: CacheImpl): CacheInterface
}