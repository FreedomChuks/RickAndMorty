package com.wisetest.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisetest.data.repository.CharacterRepository
import com.wisetest.domain.Character
import com.wisetest.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterVM @Inject constructor(private val repository: CharacterRepository):ViewModel() {

    init {
        getCharacter()
    }

    private val _uiState = MutableStateFlow<ResultState<List<Character>>>(ResultState.Empty())
    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<ResultState<List<Character>>> = _uiState

    private  fun getCharacter(){
        repository.fetchCharacter().onEach {
            _uiState.value = it
        }.launchIn(viewModelScope)
    }
}