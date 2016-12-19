package com.restart.restart.listing.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.epoxy.EpoxyAdapter
import com.restart.restart.R
import com.restart.restart.listing.ui.view.ListingAdapter
import kotlinx.android.synthetic.main.listing.*



class ListingFragment : Fragment() {

    private val adapter: EpoxyAdapter = ListingAdapter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.listing, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)

        content.layoutManager = layoutManager
        content.adapter = adapter

        adapter.notifyDataSetChanged()
    }
}