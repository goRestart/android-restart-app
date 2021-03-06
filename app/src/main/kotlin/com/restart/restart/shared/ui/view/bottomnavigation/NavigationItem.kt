package com.restart.restart.shared.ui.view.bottomnavigation

import android.view.View

interface NavigationItem {
    fun getView(): View
    fun select() {
        getView().isSelected = true
    }
    fun deselect() {
        getView().isSelected = false
    }
}