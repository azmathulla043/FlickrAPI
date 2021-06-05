package com.tech.accionflicker.Network

import com.tech.accionflicker.data.PhotoResponseData
import retrofit2.http.GET

interface ApiService {
@GET("?method=flickr.photos.search&format=json&nojsoncallback=1&text=dogs&api_key=$FLICKR_API_KEY")
suspend fun fetchImage(): PhotoResponseData
}