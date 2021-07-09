package com.wisetest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wisetest.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharacterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
    }
}