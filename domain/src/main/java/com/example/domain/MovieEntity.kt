package com.example.domain

import com.google.gson.annotations.SerializedName

data class MovieEntity(@SerializedName("id") val id: Int,
                       @SerializedName("logo_path") val logoPath: String?,
                       @SerializedName("name") val name: String)
