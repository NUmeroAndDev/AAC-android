package com.numero.aac_example.di

import android.app.Application
import com.numero.aac_example.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (FragmentModule::class),
    (ViewModelModule::class)
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: Application)
}