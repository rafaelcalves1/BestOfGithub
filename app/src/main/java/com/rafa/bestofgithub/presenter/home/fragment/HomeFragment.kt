package com.rafa.bestofgithub.presenter.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.rafa.bestofgithub.databinding.FragmentHomeBinding
import com.rafa.bestofgithub.presenter.home.adapter.RepositorysAdapter
import com.rafa.bestofgithub.presenter.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val adapter = RepositorysAdapter()

    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.homeRecycler.adapter = adapter
        adapter.addLoadStateListener { loadState ->
            loadState.mediator?.refresh
        }
        lifecycleScope.launch {
            viewModel.pegaRepository().distinctUntilChanged().collectLatest {
                adapter.submitData(it)
            }
        }
        return binding.root
    }
}