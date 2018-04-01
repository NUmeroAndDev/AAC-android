package com.numero.aac_example.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.numero.aac_example.R
import com.numero.aac_example.model.BusTime
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_holder_bus_time.*

class BusTimeListAdapter : RecyclerView.Adapter<BusTimeListAdapter.BusTimeViewHolder>() {

    var busTimeList: List<BusTime>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusTimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_bus_time, parent, false)
        return BusTimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: BusTimeViewHolder, position: Int) {
        val list = busTimeList ?: return
        holder.apply {
            setBusTime(list[position])
        }
    }

    override fun getItemCount(): Int {
        val list = busTimeList ?: return 0
        return list.size
    }

    class BusTimeViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun setBusTime(busTime: BusTime) {
            timeTextView.text = "${busTime.hour}:${busTime.minute}"
        }
    }
}