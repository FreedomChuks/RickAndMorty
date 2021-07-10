package com.wisetest.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisetest.data.model.dto.CharacterDto
import com.wisetest.data.repository.Repository
import com.wisetest.utils.ApiException
import com.wisetest.utils.NoInternetException
import com.wisetest.utils.ResultState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber


class CharacterVM @ViewModelInject constructor(private val repository: Repository):ViewModel() {

    init {
        getCharacter()
    }

    private val _characterMutableLiveData = MutableLiveData<ResultState<CharacterDto>>()
    val upcomingMovies: LiveData<ResultState<CharacterDto>> = _characterMutableLiveData

    private val _uiState = MutableStateFlow<ResultState<CharacterDto>>(ResultState.Loading())
    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<ResultState<CharacterDto>> = _uiState

    private fun getCharacter(){
        try {
            viewModelScope.launch {
                repository.getCharacter().collect {
                    _uiState.value= it
                }
            }
        }catch (e:ApiException){
            Timber.i("error $e")
        }
        catch (e: NoInternetException) {
            Timber.i("error No-Internet $e")
        } catch (e: Exception) {
            Timber.i("error Exception $e")
        }
    }
}