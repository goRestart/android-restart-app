package com.restart.restart.shared.ui.view.recyclerview.decoration

import android.graphics.Rect
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View


class WholeContentPaddingItemDecoration(val padding: Rect) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent?.getChildAdapterPosition(view) ?: return
        val itemsCount = state?.itemCount ?: return

        val layoutManager = parent?.layoutManager as GridLayoutManager
        val spanSizeLookup = layoutManager.spanSizeLookup

        outRect?.setEmpty()

        val spanCount = layoutManager.spanCount
        val spanIndex = spanSizeLookup.getSpanIndex(position, spanCount)

        if (spanIndex == 0) {
            outRect?.left = padding.left
        }

        if (spanIndex == spanCount - 1) {
            outRect?.right = padding.right
        }

        if (position == 0) {
            outRect?.top = padding.top
        }

        if (position == itemsCount - 1) {
            outRect?.bottom = padding.bottom
        }
    }
}