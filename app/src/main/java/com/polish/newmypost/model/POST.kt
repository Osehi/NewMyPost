package com.polish.newmypost.model


import com.google.gson.annotations.SerializedName

data class POST(
    var body: String?,
    var id: Int?,
    var title: String?,
    var userId: Int?
)