package com.numero.aac_example

import com.numero.aac_example.repository.BusDataRepository
import com.numero.aac_example.viewmodel.ViewModelFactory

object Injection {

    fun provideViewModelFactory(): ViewModelFactory {
        val busDataRepository = BusDataRepository()
        return ViewModelFactory(busDataRepository)
    }
}