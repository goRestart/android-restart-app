package com.restart.restart.shared.ui.behavior

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator

class VerticalScrollingBehavior<V : View> : CoordinatorLayout.Behavior<V> {

    constructor() : super()
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    companion object {
        val MIN_SCROLL_TO_ANIMATE = 6
        val ANIMATION_DURATION = 200L
    }

    private var wasBeingDisplayed = true

    override fun layoutDependsOn(parent: CoordinatorLayout?, child: V, dependency: View?): Boolean {
        return dependency is RecyclerView
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout?, child: V, directTargetChild: View?, target: View?, nestedScrollAxes: Int): Boolean {
        return true
    }

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout?, child: V, target: View?, dx: Int, dy: Int, consumed: IntArray?) {
        if (Math.abs(dy.toFloat()) < MIN_SCROLL_TO_ANIMATE) {
            return
        }

        val hasToBeDisplayed = dy < 0
        if (wasBeingDisplayed == hasToBeDisplayed) {
            return
        }

        val translationY = if (wasBeingDisplayed) child.height else 0

        child.animate()
            .translationY(translationY.toFloat())
            .setInterpolator(AccelerateDecelerateInterpolator())
            .setDuration(ANIMATION_DURATION)
            .start()


        wasBeingDisplayed = hasToBeDisplayed
    }
}