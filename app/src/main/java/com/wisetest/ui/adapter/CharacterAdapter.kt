package com.wisetest.ui.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wisetest.R
import com.wisetest.data.network.dto.CharacterData
import com.wisetest.databinding.LayoutItemBinding
import com.wisetest.ui.adapter.CharacterAdapter.CharacterViewHolder
import com.wisetest.utils.Constant


class CharacterAdapter(private val onClick:(CharacterData)->Unit): ListAdapter<CharacterData,CharacterViewHolder>(CharacterDiffCallback) {

    inner class CharacterViewHolder(private var binding: LayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var characterData: CharacterData? = null
        fun bind(characterData: CharacterData){
            with(binding){
                characterName.text=characterData.name
                characterImage.load(characterData.image)
                characterLocation.text=characterData.location.name
                status.text=characterData.status
                being.text = characterData.species
                binding.root.setOnClickListener {
                    characterData.let {
                        onClick(it)
                    }

                }
                when(characterData.status){
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
    }

    object CharacterDiffCallback : DiffUtil.ItemCallback<CharacterData>() {
        override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.id == newItem.id
        }
    }
}