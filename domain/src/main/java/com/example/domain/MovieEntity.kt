package com.example.domain

import com.google.gson.annotations.SerializedName

data class MovieEntity(@SerializedName("id") private val id: Int,
                       @SerializedName("logo_path") private val logoPath: String?,
                       @SerializedName("name") private val name: String)
