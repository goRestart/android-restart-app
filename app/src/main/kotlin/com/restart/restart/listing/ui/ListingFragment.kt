package com.restart.restart.listing.ui

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.restart.restart.R
import com.restart.restart.listing.ui.view.ListingAdapter
import com.restart.restart.listing.ui.view.viewmodel.AdViewModel
import com.restart.restart.shared.ui.RestartFragment
import com.restart.restart.shared.ui.view.recyclerview.decoration.ContentPaddingItemDecoration
import kotlinx.android.synthetic.main.profile.*


class ListingFragment : RestartFragment(), ListingPresenter.View {

    companion object {
        val NUMBER_OF_COLUMNS: Int = 2
    }

    private var adViewModelFactory: AdViewModel.Factory? = null
    private var adapter: ListingAdapter? = null
    private var presenter: ListingPresenter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.listing, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adViewModelFactory = AdViewModel.Factory(context)
        presenter = dependencyContainer!!.listing.getPresenter(this)

        adapter = ListingAdapter(adViewModelFactory!!)
        val layoutManager = StaggeredGridLayoutManager(NUMBER_OF_COLUMNS, StaggeredGridLayoutManager.VERTICAL)

        content.layoutManager = layoutManager
        content.adapter = adapter

        addContentPaddingItemDecoration()

        adapter?.notifyDataSetChanged()
    }

    override fun showProducts(products: List<AdViewModel>) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
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