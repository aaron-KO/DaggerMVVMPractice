package com.apolis.daggermvvmpractice.api

import com.apolis.daggermvvmpractice.model.WeatherResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {
    @GET("weather")
    fun getWeather(
        @Query("q") cityStateCountry: String,
        @Query("appid") appId: String,
        @Query("units") units: String
    ): Observable<WeatherResponse>


    @GET("weather")
    fun getCurrentWeather(
        @QueryMap params: HashMap<String, String>
    ): Observable<WeatherResponse>
}