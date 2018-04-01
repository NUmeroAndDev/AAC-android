package com.numero.aac_example.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.numero.aac_example.repository.BusDataRepository

class ViewModelFactory(private val busDataRepository: BusDataRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusTimeViewModel::class.java)) {
            return BusTimeViewModel(busDataRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}