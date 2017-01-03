package com.restart.restart.listing.ui

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.LazyKodeinAware
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.android.withContext
import com.github.salomonbrys.kodein.factory
import com.github.salomonbrys.kodein.lazy
import com.restart.restart.R
import com.restart.restart.listing.ui.view.ListingAdapter
import com.restart.restart.listing.ui.view.viewmodel.AdViewModel
import com.restart.restart.shared.ui.view.recyclerview.decoration.ContentPaddingItemDecoration
import kotlinx.android.synthetic.main.profile.*


class ListingFragment : Fragment(), LazyKodeinAware {

    companion object {
        val NUMBER_OF_COLUMNS: Int = 2
    }

    override val kodein = Kodein.lazy {
        extend(appKodein())
        bind<AdViewModel.Factory>() with factory { context: Context -> AdViewModel.Factory(context) }
    }

    private val adViewModelFactory: AdViewModel.Factory by withContext(this).instance()
    private var adapter: ListingAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.listing, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ListingAdapter(adViewModelFactory)
        val layoutManager = StaggeredGridLayoutManager(NUMBER_OF_COLUMNS, StaggeredGridLayoutManager.VERTICAL)

        content.layoutManager = layoutManager
        content.adapter = adapter

        addContentPaddingItemDecoration()

        adapter?.notifyDataSetChanged()
    }

    private fun addContentPaddingItemDecoration() {
        val horizontalPadding = resources.getDimension(R.dimen.listing_padding_horizontal).toInt()
        val horizontalInnerPadding = resources.getDimension(R.dimen.listing_inner_padding_horizontal).toInt()
        val bottomPadding = resources.getDimension(R.dimen.listing_padding_bottom).toInt()

        val contentPaddingItemDecoration =
            ContentPaddingItemDecoration(
                Rect(horizontalPadding, 0, horizontalPadding, bottomPadding),
                Rect(horizontalInnerPadding, 0, horizontalInnerPadding, 0))

        content.addItemDecoration(contentPaddingItemDecoration)
    }
}