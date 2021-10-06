package com.apolis.daggermvvmpractice.repository

import com.apolis.daggermvvmpractice.data.NetworkDataSource
import com.apolis.daggermvvmpractice.model.WeatherResponse
import io.reactivex.Observable
import javax.inject.Inject

class MainRepository @Inject constructor(val networkDataSource: NetworkDataSource){

    fun fetchDataFromNetwork(): Observable<WeatherResponse> {
        return networkDataSource.fetchUserData()
    }
}