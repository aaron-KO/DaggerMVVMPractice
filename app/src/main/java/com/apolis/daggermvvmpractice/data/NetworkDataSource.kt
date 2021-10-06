package com.apolis.daggermvvmpractice.data

import com.apolis.daggermvvmpractice.api.ApiService
import com.apolis.daggermvvmpractice.dagger.component.ApplicationComponent
import com.apolis.daggermvvmpractice.dagger.component.DaggerApplicationComponent
import com.apolis.daggermvvmpractice.dagger.module.ApplicationModule
import com.apolis.daggermvvmpractice.model.WeatherResponse
import io.reactivex.Observable
import javax.inject.Inject

class NetworkDataSource @Inject constructor(){
    @Inject
    lateinit var apiService: ApiService

    init {
        val daggerApplicationComponent: ApplicationComponent =
            DaggerApplicationComponent.builder().applicationModule(
                ApplicationModule()
            ).build()

        daggerApplicationComponent.inject(this)
    }
    fun fetchUserData(): Observable<WeatherResponse> {
        val city = "queens"
        val state = "NY"
        val country = "US"

        val q = "$city,$state,$country"
        val params = HashMap<String, String>()
        params["q"] = q
        params["appid"] = "82c980e0594a369b586b83ca38132a35"
        params["units"] = "metric"
        return apiService.getCurrentWeather(params)
    }
}