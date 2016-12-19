package com.restart.restart.shared.ui

import android.text.SpannableStringBuilder
import android.text.Spanned.SPAN_INCLUSIVE_EXCLUSIVE
import java.util.*

/** A [SpannableStringBuilder] wrapper whose API doesn't make me want to stab my eyes out.  */
class Truss {
    private val builder: SpannableStringBuilder
    private val stack: Deque<Span>

    init {
        builder = SpannableStringBuilder()
        stack = ArrayDeque<Span>()
    }

    fun append(string: String): Truss {
        builder.append(string)
        return this
    }

    fun append(charSequence: CharSequence): Truss {
        builder.append(charSequence)
        return this
    }

    fun append(c: Char): Truss {
        builder.append(c)
        return this
    }

    fun append(number: Int): Truss {
        builder.append(number.toString())
        return this
    }

    /** Starts `span` at the current position in the builder.  */
    fun pushSpan(span: Any): Truss {
        stack.addLast(Span(builder.length, span))
        return this
    }

    /** End the most recently pushed span at the current position in the builder.  */
    fun popSpan(): Truss {
        val span = stack.removeLast()
        builder.setSpan(span.span, span.start, builder.length, SPAN_INCLUSIVE_EXCLUSIVE)
        return this
    }

    /** Create the final [CharSequence], popping any remaining spans.  */
    fun build(): CharSequence {
        while (!stack.isEmpty()) {
            popSpan()
        }
        return builder
    }

    /**
     * Applies span to args and formats it within the base string. If there is a span
     * in the stack it will be used for the starting and / or ending piece of the string
     * which is not args
     */
    fun format(span: Any, format: String, vararg args: String): Truss {
        val formattedText = String.format(format, *args)
        val length = builder.length
        builder.append(formattedText)

        args.forEach { arg ->
            if (!stack.isEmpty()) {
                val stackSpan = stack.removeLast()
                builder.setSpan(
                    stackSpan.span,
                    stackSpan.start,
                    length + formattedText.indexOf(arg),
                    SPAN_INCLUSIVE_EXCLUSIVE)
                builder.setSpan(
                    span,
                    length + formattedText.indexOf(arg),
                    length + formattedText.indexOf(arg) + arg.length,
                    SPAN_INCLUSIVE_EXCLUSIVE)
                builder.setSpan(
                    stackSpan,
                    length + formattedText.indexOf(arg) + arg.length,
                    builder.length,
                    SPAN_INCLUSIVE_EXCLUSIVE)
                stack.addLast(Span(builder.length, stackSpan))
            } else {
                builder.setSpan(
                    span,
                    length + formattedText.indexOf(arg),
                    length + formattedText.indexOf(arg) + arg.length,
                    SPAN_INCLUSIVE_EXCLUSIVE)
            }
        }
        return this
    }

    private class Span(internal val start: Int, internal val span: Any)
}