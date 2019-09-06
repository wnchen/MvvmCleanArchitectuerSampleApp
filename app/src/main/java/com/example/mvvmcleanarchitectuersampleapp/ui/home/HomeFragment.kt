package com.example.mvvmcleanarchitectuersampleapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.MovieEntity
import com.example.mvvmcleanarchitectuersampleapp.*
import dagger.Component
import dagger.Module
import dagger.Provides
import java.util.logging.Level
import java.util.logging.Logger
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    @Inject
    internal lateinit var homeViewModel: HomeViewModel

    @Inject
    internal lateinit var viewManager: LinearLayoutManager

    @Inject
    internal lateinit var movieListAdapter: MovieListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Logger.getAnonymousLogger().log(Level.INFO, "homeViewModel address onCreateView called")
        inject()
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        bindUi(root)
        return root
    }

    private fun bindUi(root: View) {
        root.findViewById<RecyclerView>(R.id.rv_home).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = movieListAdapter
        }
        homeViewModel.observeToMovieListChange().observe(this,
            Observer<List<MovieEntity>> { movieListAdapter.updateMovieListItems(it) })
    }

    override fun onStart() {
        super.onStart()
        getPasswordPolicy()
    }

    private fun getPasswordPolicy() {
        Logger.getAnonymousLogger().log(Level.INFO, "homeViewModel address ${homeViewModel.hashCode()}")
        homeViewModel.searchMovieList("spider")
    }

    private fun inject() {
        DaggerHomeFragment_HomeFragmentComponent.builder()
            .coreComponent(App.coreComponent)
            .moduleHomeFragment(ModuleHomeFragment(this))
            .build()
            .inject(this)
    }

    @ActivityScope
    @Component(modules = [ModuleHomeFragment::class], dependencies = [CoreComponent::class])
    internal interface HomeFragmentComponent {
        fun inject(homeFragment: HomeFragment)
    }

    @Module
    internal class ModuleHomeFragment(private val homeFragment: HomeFragment) {

        @Provides
        @ActivityScope
        internal fun provideGetPasswordPolicyViewModel(): HomeViewModel {
            return ViewModelProviders.of(homeFragment, homeFragment.viewModelFactory).get(
                HomeViewModel::class.java)
        }

        @Provides
        @ActivityScope
        internal fun provideLayoutManager(): LinearLayoutManager {
            return LinearLayoutManager(homeFragment.context)
        }

        @Provides
        @ActivityScope
        internal fun provideMovieListAdapter(): MovieListAdapter {
            return MovieListAdapter(homeFragment.context!!, listOf())
        }
    }

}