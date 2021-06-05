package com.tech.accionflicker.data

data class PhotoResponseData(
    val photos: Photos,
    val stat: String
)
data class Photos(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val photo: List<PhotoResponse>,
    val total: Int
)

data class PhotoResponse(
    val farm: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String
)



