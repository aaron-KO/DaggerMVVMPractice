package com.apolis.daggermvvmpractice.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apolis.daggermvvmpractice.data.NetworkDataSource
import com.apolis.daggermvvmpractice.model.WeatherResponse
import com.apolis.daggermvvmpractice.repository.MainRepository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ActivityViewModel : ViewModel() {
    val base = ObservableField<String>()

    val error = MutableLiveData<String>()

    val success = MutableLiveData<String>()

    fun getObservers(): Observer<WeatherResponse> {
        return object : Observer<WeatherResponse> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: WeatherResponse) {

                success.postValue(" Successful")

            }

            override fun onError(e: Throwable) {
                error.postValue("error")
                e.printStackTrace()
            }

            override fun onComplete() {
            }
        }
    }
    fun getWeather() {
        val observable = MainRepository(NetworkDataSource()).fetchDataFromNetwork()
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(getObservers())
    }
}