package com.numero.aac_example.model

import java.io.Serializable

data class BusTime(val hour: Int,
                   val minute: Int,
                   val weekId: Int,
                   val isNonstop: Boolean,
                   val isOnlyOnSchooldays: Boolean) : Serializable
