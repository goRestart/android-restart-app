package com.restart.restart.ui.view.bottomnavigation

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity.CENTER
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.restart.restart.R
import kotlinx.android.synthetic.main.bottom_navigation_bar.view.*

class BottomNavigationBar : LinearLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.bottom_navigation_bar, this)
        orientation = LinearLayout.VERTICAL
    }

    fun configure(items: Array<NavigationItem>) {
        val containerViews = items
            .map { applyItemLayoutParams(it.getView()) }
            .map { createContainerView(it) }

        items.zip(containerViews).forEach {
            setOnClickListener(items, it.first, it.second)
        }

        containerViews.forEach { container.addView(it) }
    }

    private fun applyItemLayoutParams(view: View): View {
        val itemParams = FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        itemParams.gravity = CENTER
        view.layoutParams = itemParams
        return view
    }

    private fun createContainerView(view: View): ViewGroup {
        val itemContainerParams = LinearLayout.LayoutParams(0, MATCH_PARENT, 1f)
        itemContainerParams.gravity = CENTER
        val containerView = FrameLayout(context)
        containerView.layoutParams = itemContainerParams
        containerView.addView(view)
        return containerView
    }

    private fun setOnClickListener(items: Array<NavigationItem>, item: NavigationItem, view: View) {
        view.setOnClickListener {
            items.filter { it != item }
                .forEach { it.deselect() }
            item.select()
        }
    }
}