package com.example.iplocator.network_call

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "http://ip-api.com/"

interface ApiInterface {
    @GET("json/{address}")
    fun getDetails(@Path("address") address: String?): Call<ApiFields>
}

object IpService {
    val ipInstance: ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        ipInstance = retrofit.create(ApiInterface::class.java)
    }
}