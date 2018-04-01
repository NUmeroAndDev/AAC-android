package com.numero.aac_example.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.numero.aac_example.Injection
import com.numero.aac_example.R
import com.numero.aac_example.view.BusTimeListAdapter
import com.numero.aac_example.viewmodel.BusTimeViewModel
import kotlinx.android.synthetic.main.fragment_bustime_list.*

class BusTimeListFragment : Fragment() {

    private lateinit var busTimeViewModel: BusTimeViewModel
    private val busTimeAdapter: BusTimeListAdapter = BusTimeListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_bustime_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        val viewModelFactory = Injection.provideViewModelFactory()
        busTimeViewModel = ViewModelProviders.of(this, viewModelFactory).get(BusTimeViewModel::class.java)
        busTimeViewModel.busTime.observe(this, Observer {
            val list = it ?: return@Observer
            busTimeAdapter.busTimeList = list
        })
    }

    private fun initViews() {
        busTimeRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = busTimeAdapter
        }
    }

    companion object {
        fun newInstance(): BusTimeListFragment = BusTimeListFragment()
    }
}