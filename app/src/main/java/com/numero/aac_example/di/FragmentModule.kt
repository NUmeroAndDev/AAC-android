package com.numero.aac_example.di

import com.numero.aac_example.fragment.BusTimeListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeBusTimeListFragment(): BusTimeListFragment
}