package com.numero.aac_example.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.numero.aac_example.model.BusTime
import com.numero.aac_example.repository.IBusDataRepository

class BusTimeViewModel(busDataRepository: IBusDataRepository) : ViewModel() {

    var busTime: LiveData<List<BusTime>>

    init {
        busTime = busDataRepository.loadBusTimeList()
    }

}