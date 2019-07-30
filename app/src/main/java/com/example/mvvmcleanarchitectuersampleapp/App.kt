package com.example.mvvmcleanarchitectuersampleapp

import android.app.Application

class App: Application() {

    init {
        coreComponent = DaggerCoreComponent.builder()
            .moduleAppContext(ModuleAppContext(this))
            .build()
    }

    companion object {
        lateinit var coreComponent: CoreComponent
    }
}