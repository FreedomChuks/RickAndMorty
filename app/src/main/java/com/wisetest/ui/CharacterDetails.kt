package com.wisetest.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import coil.load
import com.wisetest.R
import com.wisetest.databinding.FragmentCharacterDetailsBinding
import com.wisetest.utils.Constant

class CharacterDetails : Fragment() {
    lateinit var binding:FragmentCharacterDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailsBinding.inflate(inflater,container,false)
        retrieveFromSafeArgs()
        setUpUI()
        return binding.root
    }

    private fun setUpUI() {
        binding.toolbar.setOnClickListener { findNavController().navigateUp() }
    }

    private fun retrieveFromSafeArgs(){
        arguments?.let {
            val character= CharacterDetailsArgs.fromBundle(it).character
            with(binding){
                characterImage.load(character.image)
                characterName.text = character.name
                characterLocation.text =character.location.name
                Gender.text = character.gender
                Species.text = character.species
                status.text = character.status
                description.text ="${character.name} is a mad scientist who drags his grandson, Morty, on crazy sci-fi adventures. Their escapades often have potentially harmful consequences for their family"
                when(character.status){
                    Constant.ALIVE -> {
                        with(status){
                            status.backgroundTintList= ColorStateList.valueOf(Color.parseColor("#4056CC44"))
                            status.setTextColor(resources.getColor(R.color.green))
                        }
                    }
                    Constant.DEAD -> {
                        with(status){
                            status.backgroundTintList= ColorStateList.valueOf(Color.parseColor("#FDF2F2"))
                            setTextColor(resources.getColor(R.color.red))
                        }
                    }
                    Constant.UNKNOWN -> {
                        with(status){
                            status.backgroundTintList= ColorStateList.valueOf(Color.parseColor("#403B3F43"))
                            setTextColor(resources.getColor(R.color.unknowen))
                        }
                    }
                }

            }
        }
    }
}