package com.example.navigation_component_8.data

import retrofit2.http.GET

interface ApiService {
    @GET("/api/v2/facts/random")
    suspend fun getFact(): FactBackResponse

    @GET("/api/v2/facts/today")
    suspend fun getFactToday(): FactTodayBackResponse
}