package com.numero.aac_example.repository

import android.arch.lifecycle.LiveData
import com.numero.aac_example.model.BusTime

interface IBusDataRepository {

    fun loadBusTimeList(): LiveData<List<BusTime>>

}
