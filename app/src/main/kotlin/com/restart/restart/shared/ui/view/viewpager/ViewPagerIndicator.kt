package com.restart.restart.shared.ui.view.viewpager

import android.content.Context
import android.database.DataSetObserver
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.View
import com.restart.restart.R
import com.restart.restart.shared.extensions.math.decimal
import com.restart.restart.shared.extensions.ui.dpToPixels
import com.restart.restart.shared.ui.view.math.Point

class ViewPagerIndicator :
    View,
    ViewPager.OnPageChangeListener,
    ViewPager.OnAdapterChangeListener,
    DataSetObserverInterface {

    private val paint: Paint = Paint()
    private val dataSetObserver = DataSetObserverAdapter(this)
    private var adapter: PagerAdapter? = null
    private var lastPosition: Int = 0
    private var lastPositionOffset: Float = 0f

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeWidth = 1f
    }

    fun install(viewPager: ViewPager) {
        viewPager.addOnPageChangeListener(this)
        viewPager.addOnAdapterChangeListener(this)
        viewPager.adapter.registerDataSetObserver(dataSetObserver)
        adapter = viewPager.adapter
    }

    override fun onAdapterChanged(viewPager: ViewPager, oldAdapter: PagerAdapter?, newAdapter: PagerAdapter?) {
        adapter = newAdapter
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        lastPosition = position
        lastPositionOffset = positionOffset
        postInvalidate()
    }

    override fun onPageSelected(position: Int) {
    }

    override fun onChanged() {
        postInvalidate()
    }

    override fun onInvalidated() {
        postInvalidate()
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val itemsCount = adapter?.count ?: 0
        paint.color = context.resources.getColor(R.color.cloudy)

        (1..itemsCount)
            .map { centerOfCircleAtPosition(it - 1) }
            .forEach { canvas?.drawCircle(it.x, it.y, dpToPixels(Configuration.itemSize) / 2f, paint) }

        // 2 phases
        // [0.0 - 0.5) -> Expansion to target circle
        // [0.5 - 1.0) -> Release from source circle (no source background circle)
        val offsetToNext = lastPositionOffset.decimal()
        val sourceCirclePosition = lastPosition
        val targetCirclePosition = lastPosition + 1
        val transitionRectangleStart: Float
        val transitionRectangleEnd: Float

        paint.color = context.resources.getColor(R.color.purplish_blue)
        if (offsetToNext < 0.5) {
            transitionRectangleStart = centerOfCircleAtPosition(sourceCirclePosition).x
            transitionRectangleEnd = transitionRectangleStart +
                2 * offsetToNext * (dpToPixels(Configuration.itemSize) + dpToPixels(Configuration.interItemSpace))
        } else {
            transitionRectangleEnd = centerOfCircleAtPosition(targetCirclePosition).x
            transitionRectangleStart = transitionRectangleEnd -
                2 * (1 - offsetToNext) * (dpToPixels(Configuration.itemSize) + dpToPixels(Configuration.interItemSpace))
        }

        val centerY = measuredHeight / 2f
        canvas?.drawRect(
            transitionRectangleStart,
            centerY - (dpToPixels(Configuration.itemSize) / 2f),
            transitionRectangleEnd,
            centerY + (dpToPixels(Configuration.itemSize) / 2f),
            paint
        )
        canvas?.drawCircle(transitionRectangleStart, centerY, dpToPixels(Configuration.itemSize) / 2f, paint)
        canvas?.drawCircle(transitionRectangleEnd, centerY, dpToPixels(Configuration.itemSize) / 2f, paint)
    }

    private fun centerOfCircleAtPosition(position: Int): Point {
        val itemsCount = adapter?.count ?: 0
        val centerX = measuredWidth / 2f
        val centerY = measuredHeight / 2f
        val itemsSize = itemsCount * dpToPixels(Configuration.itemSize) +
            (itemsCount - 1) * dpToPixels(Configuration.interItemSpace)
        val leftmostPointX = centerX - (itemsSize / 2f)
        return Point(
            leftmostPointX + position * (dpToPixels(Configuration.itemSize) + dpToPixels(Configuration.interItemSpace)),
            centerY
        )
    }

    object Configuration {
        val itemSize = 8
        val interItemSpace = 5
    }
}

interface DataSetObserverInterface {
    fun onChanged()
    fun onInvalidated()
}

class DataSetObserverAdapter(
    private val observer: DataSetObserverInterface
) : DataSetObserver() {
    override fun onChanged() {
        super.onChanged()
        observer.onChanged()
    }

    override fun onInvalidated() {
        super.onInvalidated()
        observer.onInvalidated()
    }
}