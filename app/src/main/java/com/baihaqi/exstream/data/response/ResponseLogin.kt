package com.baihaqi.exstream.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseLogin(
    @field:SerializedName("username")
    var username: String? = null,

    @field:SerializedName("password")
    var password: String? = null
) : Parcelable