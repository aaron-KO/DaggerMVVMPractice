package com.apolis.daggermvvmpractice.dagger.component

import com.apolis.daggermvvmpractice.dagger.module.ApplicationModule
import com.apolis.daggermvvmpractice.data.NetworkDataSource
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules= [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(networkDataSource: NetworkDataSource)
}