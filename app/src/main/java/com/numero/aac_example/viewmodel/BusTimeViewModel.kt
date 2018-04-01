package com.numero.aac_example.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.numero.aac_example.model.BusTime

class BusTimeViewModel : ViewModel() {

    var busTime: LiveData<List<BusTime>>

    init {
        // TODO Repositoryからデータを取得する
        busTime = MutableLiveData<List<BusTime>>().apply {
            postValue(listOf(BusTime(0, 0, 0,false,false)))
        }
    }

}