package com.numero.aac_example.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.numero.aac_example.model.BusTime
import javax.inject.Inject

class BusDataRepository @Inject constructor() {

    fun loadBusTimeList(): LiveData<List<BusTime>> {
        return MutableLiveData<List<BusTime>>().apply {
            postValue(listOf(BusTime(0, 0, 0, false, false)))
        }
    }
}