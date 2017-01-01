package com.restart.restart.shared.ui.view.recyclerview.decoration

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View


class ContentPaddingItemDecoration(val outerPadding: Rect, val innerPadding: Rect) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent?.getChildAdapterPosition(view) ?: return
        val itemsCount = state?.itemCount ?: return

        val layoutManager = parent?.layoutManager as StaggeredGridLayoutManager
        val layoutParams = view?.layoutParams as StaggeredGridLayoutManager.LayoutParams

        outRect?.setEmpty()

        val spanCount = layoutManager.spanCount
        val spanIndex = layoutParams.spanIndex

        if (layoutParams.isFullSpan) {
            outRect?.left = outerPadding.left
            outRect?.right = outerPadding.right
        } else if (spanIndex == 0) {
            outRect?.left = outerPadding.left
            outRect?.right = innerPadding.right
        } else if (spanIndex == spanCount - 1) {
            outRect?.left = innerPadding.left
            outRect?.right = outerPadding.right
        }

        if (position == 0) {
            outRect?.top = outerPadding.top
        }

        if (position == itemsCount - 1) {
            outRect?.bottom = outerPadding.bottom
        }
    }
}