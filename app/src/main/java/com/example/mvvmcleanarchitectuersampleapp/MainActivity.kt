package com.example.mvvmcleanarchitectuersampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.domain.MovieEntity
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    @Inject
    internal lateinit var searchMovieViewModel: SearchMovieViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindUi()
    }

    private fun bindUi() {
        searchMovieViewModel.observeToMovieListChange().observe(this,
            Observer<List<MovieEntity>> { tv_main.text = it.toString() })
    }

    override fun onStart() {
        super.onStart()
        getPasswordPolicy()
    }

    private fun getPasswordPolicy() {
        searchMovieViewModel.searchMovieList("spider")
    }

    private fun inject() {
        DaggerMainActivity_MainActivityComponent.builder()
            .coreComponent(App.coreComponent)
            .moduleMainActivity(ModuleMainActivity(this))
            .build()
            .inject(this)
    }

    @ActivityScope
    @Component(modules = [ModuleMainActivity::class], dependencies = [CoreComponent::class])
    internal interface MainActivityComponent {
        fun inject(mainActivity: MainActivity)
    }

    @Module
    internal class ModuleMainActivity(private val mainActivity: MainActivity) {

        @Provides
        @ActivityScope
        internal fun provideGetPasswordPolicyViewModel(): SearchMovieViewModel {
            return ViewModelProviders.of(mainActivity, mainActivity.viewModelFactory).get(SearchMovieViewModel::class.java)
        }
    }
}
