package com.numero.aac_example.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.numero.aac_example.R
import com.numero.aac_example.view.BusTimeListAdapter
import com.numero.aac_example.viewmodel.BusTimeViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_bustime_list.*
import javax.inject.Inject

class BusTimeListFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val busTimeViewModel: BusTimeViewModel by lazy {
        ViewModelProviders.of(this, factory).get(BusTimeViewModel::class.java)
    }
    private val busTimeAdapter: BusTimeListAdapter = BusTimeListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_bustime_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
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