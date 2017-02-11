package com.restart.restart.shared.extensions.ref

import java.lang.ref.WeakReference

operator fun <T> WeakReference<T>.invoke(): T? {
    return get()
}
