package com.baihaqi.exstream

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baihaqi.exstream.data.network.ApiConfig
import com.baihaqi.exstream.data.response.CharacterResponse
import com.baihaqi.exstream.data.response.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _listCharacter = MutableLiveData<List<ResultsItem>>()
    val listCharacter: LiveData<List<ResultsItem>> = _listCharacter

    fun getAllCharacter() {
        val apiKey = ApiConfig.API_KEY
        val client = ApiConfig.getApiService().getPopularMovies(apiKey)

        client.enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()?.results ?: emptyList()
                    _listCharacter.value = responseBody
                } else {
                    Log.e("ApiResponse", "onResponse: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("ApiError", t.message.toString())
            }
        })
    }
}