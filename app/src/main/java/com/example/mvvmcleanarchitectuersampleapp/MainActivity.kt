package com.example.mvvmcleanarchitectuersampleapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var searchMovieViewModel: SearchMovieViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindUi()
    }

    private fun bindUi() {
        tv_main.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }
        searchMovieViewModel.observeToMovieListChange().observe(this,
            Observer<List<MovieEntity>> { it -> tv_main.text = it.toString() })
    }

    override fun onStart() {
        super.onStart()
        getPasswordPolicy()
    }

    private fun getPasswordPolicy() {
        searchMovieViewModel.searchMovieList("spider")
    }

    override fun onDestroy() {
        Log.i("lifecycletest", "onDestroy called")
        super.onDestroy()
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
    interface MainActivityComponent {
        fun inject(mainActivity: MainActivity)
    }

    @Module
    class ModuleMainActivity(private val mainActivity: MainActivity) {

        @Provides
        @ActivityScope
        fun provideGetPasswordPolicyViewModel(): SearchMovieViewModel {
            return ViewModelProviders.of(mainActivity, mainActivity.viewModelFactory).get(SearchMovieViewModel::class.java)
        }
    }
}
