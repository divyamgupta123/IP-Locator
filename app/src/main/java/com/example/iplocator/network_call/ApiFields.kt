package com.example.iplocator.network_call

data class ApiFields(
    val status: String,
    val country: String,
    val regionName: String,
    val city: String,
    val lat: Float,
    val lon: Float,
    val zip: String,
    val timezone: String,
    val isp: String,
    val query: String,
)
