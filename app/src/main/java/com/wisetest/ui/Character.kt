package com.wisetest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.wisetest.data.network.dto.CharacterData
import com.wisetest.databinding.FragmentCharacterBinding
import com.wisetest.ui.adapter.CharacterAdapter
import com.wisetest.utils.ResultState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber


@AndroidEntryPoint
class Character : Fragment() {
    lateinit var binding: FragmentCharacterBinding
    private var characterAdapter =CharacterAdapter { character -> onClick(character) }


    private val viewModel by viewModels<CharacterVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater,container,false)
        setUpUI()
        subscribeObserver()
        return binding.root
    }

    private fun setUpUI() {
        binding.list.layoutManager= LinearLayoutManager(context, VERTICAL,false)
        binding.list.adapter = characterAdapter
    }

    private fun subscribeObserver() {
        lifecycleScope.launch {
            viewModel.uiState.collect { fetch->
                when(fetch){
                    is ResultState.Error -> {
                        Snackbar.make(binding.root,"${fetch.error}",Snackbar.LENGTH_LONG).show()
                    }
                    is ResultState.Loading -> {
                        Timber.i("Loading")
                    }
                    is ResultState.Success -> {
                        characterAdapter.submitList(fetch.data!!.results)
                        binding.list.adapter=characterAdapter
                        Timber.i("Success ${fetch.data}")
                    }
                }
            }
        }
    }

    private fun onClick(character: CharacterData){
        val action = CharacterDirections.actionCharacterToCharacterDetails(character)
        findNavController().navigate(action)
    }
}