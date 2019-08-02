package com.example.mvvmcleanarchitectuersampleapp

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)
