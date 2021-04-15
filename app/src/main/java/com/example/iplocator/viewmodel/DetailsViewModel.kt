package com.example.iplocator.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.iplocator.network_call.ApiFields
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsViewModel(private val repository: DetailsRepository) : ViewModel() {

    var data = MutableLiveData<ApiFields>()
    val errorMessage = MutableLiveData<String>()

    fun getDetails() {
        val response = repository.getDetails()

        response.enqueue(object : Callback<ApiFields> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<ApiFields>, response: Response<ApiFields>) {
                data.postValue(response.body())

            }

            override fun onFailure(call: Call<ApiFields>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }


}