package com.sync.rickandmorty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import android.util.Log



class MainViewModel : ViewModel() {
    private val _characterDetail = MutableLiveData<Character?>()
    val characterDetail: LiveData<Character?> = _characterDetail

    fun fetchCharacterById(characterId: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCharacter(characterId)
                if (response.isSuccessful) {
                    // Log success and show the fetched character data
                    Log.d("MainViewModel", "Fetched character data: ${response.body()}")
                    _characterDetail.postValue(response.body())
                } else {
                    // Log failure
                    Log.d("MainViewModel", "API Call Failed: ${response.errorBody()?.string()}")
                    _characterDetail.postValue(null)
                }
            } catch (e: Exception) {
                // Log error
                Log.e("MainViewModel", "Error fetching character", e)
                _characterDetail.postValue(null)
            }
        }
    }
}
