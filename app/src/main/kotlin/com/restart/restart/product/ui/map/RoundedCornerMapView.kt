package com.restart.restart.product.ui.map

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import com.google.android.gms.maps.MapView


class RoundedCornerMapView : MapView {

    private val rect = RectF()
    private val paint = Paint()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        rect.set(0f, 0f, (right - left).toFloat(), (bottom - top).toFloat())
    }

    override fun dispatchDraw(canvas: Canvas?) {
        val path = Path()
        val stack = canvas?.save()

        val cornerRadius = convertDpToPixel(8f)
        path.addRoundRect(rect, cornerRadius, cornerRadius, Path.Direction.CW)

        canvas?.clipPath(path)
        super.dispatchDraw(canvas)
        canvas?.restoreToCount(stack!!)
    }

    private fun convertDpToPixel(dp: Float): Float {
        val resources = context.resources
        val metrics = resources.displayMetrics
        return dp * (metrics.densityDpi / 160f)
    }
}
