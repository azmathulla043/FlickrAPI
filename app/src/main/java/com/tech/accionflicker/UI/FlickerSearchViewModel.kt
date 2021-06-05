package com.tech.accionflicker.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.accionflicker.Network.ClientRequest
import com.tech.accionflicker.data.Photo
import kotlinx.coroutines.launch

class FlickerSearchViewModel : ViewModel() {
    private val _mutableFlickerLiveData = MutableLiveData<List<Photo>>()
    val FlickerLiveData : LiveData<List<Photo>> = _mutableFlickerLiveData
    init {
        viewModelScope.launch {
            val flickerResponse =  ClientRequest.client.fetchImage()
            val flickerList = flickerResponse.photos.photo.map {
                Photo(
                    id = it.id,
                    url = "https://farm${it.farm}.staticflickr.com/${it.server}/${it.id}_${it.secret}.jpg",
                    title = it.title
                )
            }
            _mutableFlickerLiveData.postValue(flickerList)
        }
    }
}