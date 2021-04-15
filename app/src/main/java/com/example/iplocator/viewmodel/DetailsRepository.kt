package com.example.iplocator.viewmodel

import com.example.iplocator.network_call.ApiInterface

class DetailsRepository constructor(
    private val retrofitService: ApiInterface,
    private val ipAddress: String,
) {
    fun getDetails() = retrofitService.getDetails(ipAddress)
}