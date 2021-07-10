package com.wisetest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wisetest.databinding.ActivityCharacterBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharacterActivity : AppCompatActivity() {
    lateinit var binding:ActivityCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}